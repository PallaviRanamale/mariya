# Distributed Systems Lab Programs (Linux + VS Code)

This repo contains 6 classic distributed systems programs:

- Bully Election (Java)
- Ring Election (Java)
- Token Ring (Java)
- Berkeley Clock Sync (Python sockets)
- MPI examples (Java + MPJ Express)
- CORBA String Reverse (IDL + Java stubs)

All commands below are intended to be run in the **VS Code terminal on Linux**.

## 0) Get the code on Linux

### Clone (recommended)

```bash
git clone https://github.com/PallaviRanamale/mariya.git
cd mariya
```

### Or download ZIP

```bash
curl -L -o mariya.zip https://github.com/PallaviRanamale/mariya/archive/refs/heads/main.zip
unzip mariya.zip
cd mariya-main
```

## 1) Bully Algorithm (Java)

### Compile

```bash
javac Bully.java
```

### Run

```bash
java Bully
```

## 2) Ring Election Algorithm (Java)

### Compile

```bash
javac RingElection.java
```

### Run

```bash
java RingElection
```

## 3) Token Ring Algorithm (Java)

You need **3 terminals** (or more) because each node runs separately.

### Compile

```bash
javac TokenRing.java
```

### Run (example with 3 nodes)

Terminal 1 (Node 0):

```bash
java TokenRing 0 3
```

Terminal 2 (Node 1):

```bash
java TokenRing 1 3
```

Terminal 3 (Node 2):

```bash
java TokenRing 2 3
```

Where:

- first number = node id
- second number = total nodes

## 4) Berkeley Algorithm (Python)

Files are in `BerkleyAlgo/` (note the spelling).

### Run server

Terminal 1:

```bash
cd BerkleyAlgo
python3 Server.py
```

### Run clients

Terminal 2:

```bash
cd BerkleyAlgo
python3 Client.py
```

Terminal 3 (optional second client):

```bash
cd BerkleyAlgo
python3 Client.py
```

If `python3` isn’t available on your distro:

```bash
python Server.py
```

## 5) MPI (Java + MPJ Express)

Programs are in the `MPI/` folder.

### Compile (example for `MpiSum.java`)

```bash
cd MPI
javac -cp /home/$USER/mpj/lib/mpj.jar MpiSum.java
```

Adjust the `mpj.jar` path if MPJ Express is installed elsewhere.

### Run

```bash
/home/$USER/mpj/bin/mpjrun.sh -np 4 MpiSum
```

Where `-np 4` means 4 processes.

## 6) CORBA String Reverse

CORBA is easiest with **Java 8**, because CORBA tools were removed from the JDK after Java 8.

Sources are under `CORBA/` and `CORBA/src/`.

### Generate stubs from IDL

```bash
cd CORBA
idlj -fall StringReverse.idl
```

### Compile (from `CORBA/src`)

```bash
cd src
javac StringReverseApp/*.java *.java
```

### Start naming service

Terminal 1:

```bash
tnameserv -ORBInitialPort 1050
```

### Run server

Terminal 2 (still in `CORBA/src`):

```bash
java StringReverseServer -ORBInitialPort 1050 -ORBInitialHost localhost
```

### Run client

Terminal 3 (still in `CORBA/src`):

```bash
java StringReverseClinet -ORBInitialPort 1050 -ORBInitialHost localhost
```

Note: the client filename/class in this repo is `StringReverseClinet` (spelling as committed).

## Helpful installs (Ubuntu/Debian)

```bash
sudo apt update
sudo apt install -y default-jdk python3 unzip curl
```

Check versions:

```bash
java -version
javac -version
python3 --version
```

## VS Code terminal shortcut

- `Ctrl` + `` ` `` (backtick key below `Esc`)

## Web Services (Problem 7.1–7.5) in NetBeans 8 + JDK 8

Ready-to-open NetBeans Maven projects are included here:

- `WebServices_7x_JDK8_NetBeans8/DS7_Producer` (Producer / REST service)
- `WebServices_7x_JDK8_NetBeans8/DS7_Consumer` (Consumer / client)

Producer base URL: `http://localhost:5000/`

Endpoints:

- 7.1: `GET /calc?a=10&b=4&op=add`
- 7.2: `GET /si?p=1000&r=5&t=2`
- 7.3: `GET /hello?name=Alice`
- 7.4/7.5: `GET /miles_to_km?miles=10`

