from django.db import models

# Create your models here.
class Model1(models.Model):
    text = models.CharField(max_length=255)
