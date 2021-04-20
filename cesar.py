import sys

def cesar(nb: int,name: str) -> str:
    f = open(name, "r")
    data=""
    for i in f.readlines():
        for j in i:
            #ord -> return ascii, chr-> return char
            data+= chr((ord(j)+nb)%256)
        data+="\n"
    f.close()
    return data
    

def merge(nb: int, names: list) -> None:
    newFile = open(names[0]+"EcryptedMerge")
    data = ""
    for i in names:
        data+=cesar(nb, i)+"\n"
    newFile.write(data)
    newFile.close()

argv = sys.argv
if len(argv) < 3:
    print("Minimal args: nb -> shift of cesar, name -> name of one file")
    print("You can add more file, just add theire name")
    quit()

merge(argv[1], argv[2:])