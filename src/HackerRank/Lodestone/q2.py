from collections import defaultdict
#
# Complete the 'textFormatting' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY starting
#  2. INTEGER_ARRAY ending
#  3. CHARACTER_ARRAY style
#

def merge(intervals):
    intervals.sort(key=lambda x: x[0])
    merged = []
    count = 0
    for interval in intervals:
        interval = [*interval]
        if not merged or merged[-1][1] < interval[0]:
            merged.append(interval)
        else:
            merged[-1][1] = max(merged[-1][1], interval[1])
            count += 1
    return merged, count


def combine_ranges(start, end, cached):
    out = []
    update = False
    while True:
        op = 1
        for r in cached:
            if r[0] <= start <= r[1]:
                update = True
                op = 0
                r[1] = end
                start = r[0]
            elif r[0] <= end <= r[1]:
                r[0] = start
                op = 0
                update = True
                end = r[1]
        if op:
            break
    return update


def textFormatting(starting, ending, style):
    n = len(starting)
    count = 0
    cache = defaultdict(set)
    for i in range(n):
        if (starting[i], ending[i]) in cache[style[i]]:
            count -= 1
            continue
        cache[style[i]].add((starting[i], ending[i]))
    # merge intervals
    for st in style:
        intervals = cache[st]
        cache[st], m_count = merge(list(intervals))
        print(cache[st], m_count)
        count -= m_count
    for key in cache.keys():
        count += len(cache[key])
    count += n
    print(cache)
    return count
