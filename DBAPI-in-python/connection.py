import sqlite3

conn = sqlite3.connect('/home/harish/seqnumber.db')
print "Opened database successfully";
channelName = 'public'
lastSequenceNumber = 3
conn.execute("INSERT OR REPLACE INTO TRACKSEQNUMBER (CHANNELNAME,LASTSEQUENCENUMBER) \
      VALUES (:channelName,:lastSequenceNumber)", {'channelName':channelName,'lastSequenceNumber':lastSequenceNumber});
conn.commit()

print "Latest sequence number has been updated";
cursor = conn.execute("SELECT * FROM TRACKSEQNUMBER WHERE CHANNELNAME=:channelName",{'channelName':channelName});
for row in cursor:
   print "CHANNELNAME = ", row[0]
   print "SEQUENCENUMBER = ", row[1]
conn.close()
