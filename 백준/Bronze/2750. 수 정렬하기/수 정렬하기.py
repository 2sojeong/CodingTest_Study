def sort(list):
    for j in range(1,len(list)):
        key=list[j]
        i=j-1
        while i>=0 and list[i]>key:
            list[i+1]=list[i]
            i-=1
        list[i+1]=key
    

def mklist(n):
    _list=[]
    for i in range(n):
        num=int(input())
        _list.append(num)
    return _list

def print_list(a):
    for i in range(len(a)):
        print(a[i])

num=int(input())
input_list=mklist(num)
sort(input_list)
print_list(input_list)