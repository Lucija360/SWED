# Define the Collatz function with memoization support
def collatz(n, memo):
    original = n        # Keep the original number to memoize the total steps at the end
    steps = 0           # Track the number of steps taken to reach 1

    # Continue until we reach 1
    while n != 1:
        # If we've already computed the steps for this number, use the cached value
        if n in memo:
            steps += memo[n]  # Add the memoized steps
            break             # Stop the loop, we’ve found a shortcut
        # Apply the Collatz rules
        if n % 2 == 0:
            n //= 2           # If even, divide by 2
        else:
            n = 3 * n + 1     # If odd, multiply by 3 and add 1
        steps += 1            # Count each step

    # Cache the number of steps for the original input
    memo[original] = steps
    return steps              # Optionally return steps if needed elsewhere

# Function to verify the Collatz conjecture for numbers up to a given limit
def verify_collatz_upto(limit):
    memo = {1: 0}  # Start the memo dictionary with base case: 1 takes 0 steps to reach 1

    # Loop through all numbers from 1 up to the limit
    for i in range(1, limit):
        collatz(i, memo)  # Compute and memoize steps for each number

    # If the loop completes, the conjecture holds for all numbers < limit
    print(f"All numbers from 1 to {limit} eventually reach 1 using memoization.")

# Call the function to verify all numbers less than 1,000,000
verify_collatz_upto(1_000_000)
