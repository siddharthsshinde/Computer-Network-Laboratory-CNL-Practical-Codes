import socket

# Set up the client
HOST = '127.0.0.1'
PORT = 12345
# Create a UDP socket
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

# Read the file
with open('Myfile3.txt', 'rb') as f:
    data = f.read()

# Send the file
s.sendto(data, (HOST, PORT))
print("File has been sent successfully.")
