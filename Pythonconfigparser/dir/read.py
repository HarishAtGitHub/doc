import ConfigParser

config = ConfigParser.RawConfigParser()
config.read('../conf/settings.conf')

print config.get('couchbase', 'key')
print config.get('couchbase', 'bucketUrl')
print config.get('webserver', 'serverUrl')
print config.get('db', 'dblocation')
