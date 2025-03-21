def isValid(s):
    stack = []
    mapping = { ')': '(', '}': '{', ']': '['}
    
    for char in s:
        if char in mapping:
            top = stack.pop() if stack else '#'
            if top != mapping[char]:
                return False
        else:
            stack.append(char)
    
    return not stack