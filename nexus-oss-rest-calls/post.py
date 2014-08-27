import requests
from requests.auth import HTTPBasicAuth
import json
# values to be got from the UI form in our integrated app
# if needed we can replicate all fields
repo_id = 'works6' #Repository ID
repo_name = 'works6' #Repository Name
repo_uri = 'http://10.2.0.163:8081/nexus/content/repositories' + repo_id
provider = 'maven2' #Provider and Format
repoType = 'hosted' #Repository Type
exposed = True #Publish URL
browseable = True #Allow File Browsing
indexable = False #Include in Search
notFoundCacheTTL = 1440 #Not Found Cache TTL
repoPolicy = 'RELEASE' #Repository Policy
writePolicy = 'ALLOW_WRITE_ONCE' #Deployment Policy
defaultLocalStorageUrl = 'file:/media/harish/storage/installation/nexus/nexus-2.6.3-bundle/sonatype-work/nexus/storage/' + repo_id
#not sure what downloadRemoteIndexes is
payload = {
    'data': {
        'contentResourceURI': repo_uri,
        "id": repo_id,
        "name": repo_name,
        "provider": provider,
        "providerRole": "org.sonatype.nexus.proxy.repository.Repository",
        "format": provider,
        "repoType": repoType,
        "exposed": exposed,
        "writePolicy": writePolicy,
        "browseable": browseable,
        "indexable": indexable,
        "notFoundCacheTTL": notFoundCacheTTL,
        "repoPolicy": repoPolicy,
        "downloadRemoteIndexes": False,
        "defaultLocalStorageUrl": defaultLocalStorageUrl
    }
}

response = requests.post('http://10.2.0.163:8081/nexus/service/local/repositories',data=json.dumps(payload),  auth=HTTPBasicAuth('admin', 'admin'), headers={'Content-type': 'application/json'})

if ( response.status_code == 201 ):
    print('successfully created repository with id %s' % (repo_id))
else:
    print('Failed to create repository with id %s' % (repo_id))


