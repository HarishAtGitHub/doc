import sqlite3

conn = sqlite3.connect('/home/harish/seqnumber.db')
print "Opened database successfully";

conn.execute('''CREATE TABLE TRACKSEQNUMBER
       (
        CHANNELNAME TEXT PRIMARY KEY    NOT NULL,
        LASTSEQUENCENUMBER INT     NOT NULL,
        UNIQUE (CHANNELNAME)
       );''')
print "Table created successfully";

conn.close()
