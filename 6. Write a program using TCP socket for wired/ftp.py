import socket
import os

# Create a socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

# Bind the socket to a specific host and port
s.bind(("", 12007))

# Listen for incoming connections with a backlog of 2
s.listen(2)

while True:
    # Accept a connection from a client
    c, addr = s.accept()

    # Specify the directory path from which you want to serve files
    path = "C:\\Users\\SIDDHARTH SHINDE\\Desktop\t\est"

    # Get the list of files in the specified directory
    dirlist = os.listdir(path)

    # Convert the list of filenames to a space-separated string
    flist = " ".join(dirlist)

    # Send the list of files to the client
    c.send(flist.encode())

    # Receive the filename from the client
    data = c.recv(1024).decode()

    # Construct the full file path
    file_path = os.path.join(path, data)

    if os.path.exists(file_path):
        # Open the file and read its contents in binary mode
        with open(file_path, "rb") as f:
            file_data = f.read(5100)
        c.send(file_data)
    else:
        # If the file doesn't exist, send an error message
        c.send("File not found".encode())

    # Close the connection
    c.close()
