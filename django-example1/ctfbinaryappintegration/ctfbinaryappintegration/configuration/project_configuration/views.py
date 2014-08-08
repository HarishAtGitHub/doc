from django.shortcuts import render_to_response
from django.http import HttpResponse
from .models import Sample

def home(request):
    return render_to_response('configuration/project_configuration/home.html',{'greetings' : Sample.objects.all()})
