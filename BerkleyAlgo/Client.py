import socket
import time

PORT = 5001
HOST = '127.0.0.1'

client = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
client.connect((HOST,PORT))

client_time = time.time()
print(f"Client time {client_time}")

client.send(str(client_time).encode())

offset = float(client.recv(1024).decode())
print(f"Client Offset : {offset}")

new_time = client_time + offset
print(f"Client Time Adjust by {new_time}")

client.close()