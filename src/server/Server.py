print "hello world"
import socket
soc = socket.socket()
host = "localhost"
port = 4444
soc.bind((host,port))
soc.listen(5)
while True:
    conn,addr=soc.accept()
    print("Got connection from", addr)
    msg=conn.rev(1024)
    print(msg)
