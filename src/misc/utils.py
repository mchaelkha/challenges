# math stuff
a, b = 0, 0
c = min(a, b)
d = max(a, b)
e = abs(-100)

# lists
x = [1, 2, 3]
x.sort(key=lambda y: (y[0], y[1]))

## any iterable
x = sorted(x, lambda y: (y[0], y[1]))

## binary search
def binary_search(arr, low, high, x):
    # Check base case
    if high >= low:
        mid = (high + low) // 2
        # If element is present at the middle itself
        if arr[mid] == x:
            return mid
        # If element is smaller than mid, then it can only
        # be present in left subarray
        elif arr[mid] > x:
            return binary_search(arr, low, mid - 1, x)
        # Else the element can only be present in right subarray
        else:
            return binary_search(arr, mid + 1, high, x)
    else:
        # Element is not present in the array
        return -1

# Test array
x = 10
# Function call
result = binary_search([ 2, 3, 4, 10, 40 ], 0, len(arr)-1, x)
