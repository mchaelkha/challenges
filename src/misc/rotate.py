# counterclockwise rotation
def ccw(m):
    return [[m[j][i] for j in range(len(m))] for i in range(len(m[0])-1,-1,-1)]

# clockwise rotation
def cc(m):
    return list(list(x) for x in zip(*m[::-1]))

if __name__ == '__main__':
    m = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
    print(m)

    print(ccw(m))
    print(cc(m))
