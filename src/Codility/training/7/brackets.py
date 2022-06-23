def solution(S):
    stack = []
    lut = {'{': '}', '[': ']', '(': ')'}
    for s in S:
        if s in lut.keys():
            stack.append(s)
        else:
            if not stack:
                return 0
            val = stack.pop()
            if lut[val] != s:
                return 0
    return 1 if len(stack) == 0 else 0
