terraform {
  required_version = ">= 1.5.0"

  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 5.0"
    }
    tls = {
      source  = "hashicorp/tls"
      version = "~> 4.0"
    }
  }
}

provider "aws" {
  region = var.aws_region
}

# Chave SSH para acesso via GitHub Actions
resource "tls_private_key" "ssh" {
  algorithm = "RSA"
  rsa_bits  = 4096
}

resource "aws_key_pair" "deploy_key" {
  key_name   = "sistema-ordem-servico-key"
  public_key = tls_private_key.ssh.public_key_openssh
}

resource "local_file" "private_key" {
  content         = tls_private_key.ssh.private_key_pem
  filename        = "${path.module}/deploy_key.pem"
  file_permission = "0600"
}

# Security Group do Banco de Dados
resource "aws_security_group" "db_sg" {
  name        = "sistema-ordem-servico-db-sg"
  description = "Permite conexao MySQL na porta 3306 vinda do EC2"

  ingress {
    description     = "MySQL vindo do servidor da aplicacao"
    from_port       = 3306
    to_port         = 3306
    protocol        = "tcp"
    # Associa diretamente ao SG do seu servidor EC2
    security_groups = [aws_security_group.app_sg.id]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "sistema-ordem-servico-db-sg"
  }
}

# Instancia do Banco RDS MySQL
resource "aws_db_instance" "mysql" {
  allocated_storage      = 20
  max_allocated_storage   = 20
  storage_type            = "gp2"
  engine                  = "mysql"
  engine_version          = "8.0"
  instance_class          = "db.t3.micro" # Suportado na AWS Free Tier / AWS Labs
  db_name                 = "ordem_servico"
  username                = "root"
  password                = var.db_password
  parameter_group_name    = "default.mysql8.0"
  vpc_security_group_ids  = [aws_security_group.db_sg.id]
  skip_final_snapshot     = true

  tags = {
    Name        = "sistema-ordem-servico-mysql"
    Environment = "dev"
    ManagedBy   = "terraform"
  }
}

# Busca dinamica da AMI do Ubuntu 22.04 LTS
data "aws_ami" "ubuntu" {
  most_recent = true
  filter {
    name   = "name"
    values = ["ubuntu/images/hvm-ssd/ubuntu-jammy-22.04-amd64-server-*"]
  }
  owners = ["099720109477"]
}

resource "aws_security_group" "app_sg" {
  name        = "sistema-ordem-servico-sg"
  description = "Permite HTTP, HTTPS e SSH"

  ingress {
    description = "SSH"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    description = "Aplicacao (Spring Boot)"
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  tags = {
    Name = "sistema-ordem-servico-sg"
  }
}

resource "aws_instance" "app_server" {
  ami                    = data.aws_ami.ubuntu.id
  instance_type          = var.instance_type
  key_name               = aws_key_pair.deploy_key.key_name
  vpc_security_group_ids = [aws_security_group.app_sg.id]

  tags = {
    Name        = "sistema-ordem-servico-app-server"
    Environment = "dev"
    ManagedBy   = "terraform"
  }
}