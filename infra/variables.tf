variable "aws_region" {
  description = "Regiao da AWS"
  type        = string
  default     = "us-east-1"
}


variable "instance_type" {
  description = "Tipo da instancia EC2"
  type        = string
  default     = "t2.micro"
}

variable "db_password" {
  description = "Senha do usuario master do MySQL"
  type        = string
  sensitive   = true
}