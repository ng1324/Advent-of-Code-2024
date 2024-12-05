from collections import defaultdict

a = [i.strip() for i in open(0)]

dicleft, dicright = defaultdict(list), defaultdict(list)
p1 = 0
result = 0
resultp2 = 0
for item in a:
    if len(item) == 0:
        p1 = 1
        continue

    if p1 == 0:
        b = item.split('|')
        if len(b) == 2: 
            dicright[b[0]].append(b[1])
            dicleft[b[1]].append(b[0])
    elif p1 == 1:
        valid = 0
        line = item.split(',')
        if len(line) > 1:  
            for i in line[1:-1]:
                if i in dicleft[line[0]] or i in dicright[line[-1]]:
                    valid = 1
        if valid == 0:
            result += int(line[len(line) // 2])
        else:
            updated = []
            temp = line.copy() 
            remain = []
            for i in range(len(line)):
                temp.remove(line[i])  #
                if not any(k in dicleft[line[i]] for k in temp):
                    updated.append(line[i]) 
                else:
                    remain.append(line[i])
            for i in remain:
                if dicright[i] == []:
                    updated.insert(len(updated), i)
                    continue
                else: 
                    b = [x for x in dicright[i] if x in updated]
                    k = -len(b)
                    while True:
                        if any(x in updated[:k] for x in [i]): 
                            k -= 1  
                            continue
                        else:
                            updated.insert(len(updated) + k, i) 
                            break 
            resultp2 += int(updated[len(updated) // 2])
          
            
print(result)
print(resultp2)
