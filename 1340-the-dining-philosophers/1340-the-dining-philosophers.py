import threading
from typing import Callable

class DiningPhilosophers:

    def __init__(self):
        # Create 5 locks, one for each fork
        self.forks = [threading.Lock() for _ in range(5)]

    def wantsToEat(self,
                   philosopher: int,
                   pickLeftFork: Callable[[], None],
                   pickRightFork: Callable[[], None],
                   eat: Callable[[], None],
                   putLeftFork: Callable[[], None],
                   putRightFork: Callable[[], None]) -> None:
        
        left = philosopher
        right = (philosopher + 1) % 5

        # To prevent deadlock, always acquire the lower-numbered fork first
        first, second = (left, right) if left < right else (right, left)

        # Get the locks corresponding to the forks
        first_lock = self.forks[first]
        second_lock = self.forks[second]

        # Use nested context managers to lock both forks
        with first_lock:
            with second_lock:
                # Pick up forks in correct order
                if first == left:
                    pickLeftFork()
                    pickRightFork()
                else:
                    pickRightFork()
                    pickLeftFork()

                # Eat
                eat()

                # Put down forks in the same order
                if first == left:
                    putLeftFork()
                    putRightFork()
                else:
                    putRightFork()
                    putLeftFork()

        