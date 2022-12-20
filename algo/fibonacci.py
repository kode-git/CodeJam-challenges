
import functools

@functools.lru_cache(None) # it is required for big number and lazy memorization
def fibonacci(n):
    if n == 0 or n == 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)


if __name__ == '__main__':
    n = fibonacci(104)
    print(f'Value: {n}')