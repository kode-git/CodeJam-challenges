'''''''''''
brent(f, x) -> int int:
    power = 1
    lam = 1
    tortoise = x
    hare = next(x)
    while tortoise != hare:
        if power == lam:
            tortoise = hare
            power *= 2
            lam = 0
        hare = next(hare)
        lam += 1
    
    tortoise = hare = x

    # move hare to the lam position (lambda is the distance between tortoise and hare)
    for i in range(lam):
        hare = next(hare) 
    
    mu = 0
    while tortoise != hare:
        tortoise = next(tortoise)
        hare = next(hare)
        mu += 1
    return lam, mu

'''''''''''