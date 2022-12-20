'''''
Given a string, define the maximum length of the set of words
'''

def get_max_length(s : str):
    a = s.split(' ')
    m = 0
    for el in a:
        if m < len(el):
            m = len(el)
    return m


if __name__ == '__main__':
    input = 'This problem is from Leetcode'
    print(f'Input: {input}')
    len = get_max_length(input)
    print(f'Output: {len}')
