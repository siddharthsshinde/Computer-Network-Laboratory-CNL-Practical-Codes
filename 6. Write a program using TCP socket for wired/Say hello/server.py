import socket

HOST = '127.0.0.1'  # Standard loopback interface address (localhost)
PORT = 3333

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    conn, addr = s.accept()
    with conn:
        print('Connected by', addr)
        while True:
            data = conn.recv(1024).decode()
            print('Client says:', data)
            if data == 'stop':
                break
            str2 = input("Enter your message: ")
            conn.sendall(str2.encode())

