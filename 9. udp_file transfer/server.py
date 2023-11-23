import socket

# Set up the server
HOST = '127.0.0.1'
PORT = 12345

# Create a UDP socket
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
s.bind((HOST, PORT))

# Receive the file
data, addr = s.recvfrom(1024)
with open('received_file.txt', 'wb') as f:
    f.write(data)

print("File has been received successfully.")
