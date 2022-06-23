def paperCuttings(textLength, A, B):
    count = 0
    segments = [(A[i], B[i]) for i in range(len(A))]
    segments.sort(key=lambda x: x[0])
    n = len(A)
    seen = set()
    for i in range(len(segments)):
        for j in range(i , len(segments)):
            a = segments[i]
            b = segments[j]
            if a[1] < b[0] and not (a, b) in seen:
                seen.add((a, b))
                count += 1
    return count
