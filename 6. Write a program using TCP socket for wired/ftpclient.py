import socket

# Create a socket
c = socket.socket()

# Connect to the server
c.connect(("localhost", 12007))

while True:
    print("File listing from the server is\n", c.recv(5000).decode())

    # Receive the file name input from the user
    data = input("Enter the file name to download: ")

    # Send the file name to the server
    c.send(data.encode())

    # Open the file for writing in binary mode
    with open(data, "wb") as f:
        while True:
            # Receive data from the server
            b = c.recv(5000)
            
            # Break the loop if no more data is received
            if not b:
                break
            
            # Write the received data to the file
            f.write(b)

        print("File is downloaded successfully")

# Close the connection
c.close()
