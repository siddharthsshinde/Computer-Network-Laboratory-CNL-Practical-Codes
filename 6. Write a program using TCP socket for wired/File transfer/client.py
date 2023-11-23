import socket

host = "127.0.0.1"
port = 12000
buffer_size = 1024
file_name = 'Myfile.txt'

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

f = open("Myfile.txt", "r")
print("File opened")
data = f.read(buffer_size)

while data:
    print(data)
    if(sock.sendto(str.encode(data), (host, port))):
        data = f.read(buffer_size)
sock.sendto(str.encode("Now"),(host, port))
sock.close()
f.close()
