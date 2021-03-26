import os

cars = ["b19c5982", "22523b3223047ece"]
port = 4723
mjpegserverport = 4726
systemPort = 4729
for x in cars:
    fin = open("usingPython3.py", "rt")
    fout = open("scripts/"+x+".py", "wt")
    for line in fin:
	    fout.write(line.replace('SERIAL', x).replace('PORTNUMBER', str(port)).replace('MJPEGSERVERPORT',str(mjpegserverport).replace('SYSTEMPORT',str(systemPort))))
    os.system("python3 scripts/"+x+".py &")
    port += 1
    mjpegserverport += 1
    systemPort += 1

fin.close()