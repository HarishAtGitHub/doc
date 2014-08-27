import requests
from requests.auth import HTTPBasicAuth
#param comes from ui
repo_id = 'well'
reponse = requests.delete('http://10.2.0.163:8081/nexus/service/local/repositories/' + repo_id, auth=HTTPBasicAuth('admin', 'admin'))
if (reponse.status_code == 204):
    print('Successfully deleted the repository %s' % (repo_id))
else:
    print('Failed to delete the repository %s' % (repo_id))
