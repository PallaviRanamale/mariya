import time;
import socket;

HOST = '127.0.0.1'
PORT = 5001
NUM_CLIENTS = 2

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST,PORT))
server.listen(NUM_CLIENTS)

print("Berkeley Algo Starts...")

clients = []
client_times = []

for i in range(NUM_CLIENTS):
    conn,addr = server.accept()
    print(f"Client {i} connects with {addr}")
    clients.append(conn)

for i,conn in enumerate(clients):
    client_time = float(conn.recv(1024).decode())
    print(f"client {i} client time {client_time}")
    client_times.append(client_time)

master_time = time.time()
print(f"Master Time is {master_time}")

total = master_time + sum(client_times)
avg = total/(NUM_CLIENTS+1)

for i,conn in enumerate(clients):
    offset = avg - client_times[i]
    conn.send(str(offset).encode())
    print(f"client {i} offset is {offset}")

master_offset = avg - master_time
print(f"Master should adjust by {master_offset}")

server.close()
