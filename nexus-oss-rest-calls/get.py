import requests
from requests.auth import HTTPBasicAuth
response = requests.get('http://10.2.0.163:8081/nexus/service/local/repositories', auth=HTTPBasicAuth('admin', 'admin'), headers={'accept':'application/json'})
if ( response.status_code == 200 ):
    repo_list = response.json()['data']
    for repo in repo_list:
        print('repo name: %s , repo id: %s' % (repo['id'], repo['name']))
else:
    print('Failed to get the list of repositories')
