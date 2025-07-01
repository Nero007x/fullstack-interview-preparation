from typing import List
from collections import defaultdict

class Solution:
    def basicCalculatorIV(self, expression: str, evalvars: List[str], evalints: List[int]) -> List[str]:
        import collections

        evalmap = dict(zip(evalvars, evalints))

        def parse(expr):
            def to_tokens(s):
                return s.replace("(", " ( ").replace(")", " ) ").split()

            def combine(p1, p2):
                res = collections.Counter()
                for vars1, coeff1 in p1.items():
                    for vars2, coeff2 in p2.items():
                        new_vars = tuple(sorted(vars1 + vars2))
                        res[new_vars] += coeff1 * coeff2
                return res

            def add(p1, p2):
                res = collections.Counter(p1)
                for k, v in p2.items():
                    res[k] += v
                return res

            def sub(p1, p2):
                res = collections.Counter(p1)
                for k, v in p2.items():
                    res[k] -= v
                return res

            def make(val):
                if isinstance(val, int):
                    return collections.Counter({(): val})
                elif val in evalmap:
                    return collections.Counter({(): evalmap[val]})
                elif val.isalpha():
                    return collections.Counter({(val,): 1})
                else:
                    return collections.Counter({(): int(val)})

            tokens = to_tokens(expr)
            stack = []
            ops = []

            def reduce():
                b = stack.pop()
                a = stack.pop()
                op = ops.pop()
                if op == '+':
                    stack.append(add(a, b))
                elif op == '-':
                    stack.append(sub(a, b))
                elif op == '*':
                    stack.append(combine(a, b))

            i = 0
            while i < len(tokens):
                token = tokens[i]
                if token == '(':
                    ops.append(token)
                elif token == ')':
                    while ops[-1] != '(':
                        reduce()
                    ops.pop()
                elif token in "+-*":
                    while ops and ops[-1] != '(' and (ops[-1] == '*' or (token in "+-" and ops[-1] in "+-")):
                        reduce()
                    ops.append(token)
                else:
                    stack.append(make(token))
                i += 1

            while ops:
                reduce()

            return stack[0]

        poly = parse(expression)

        # Remove 0 coefficient terms
        poly = {k: v for k, v in poly.items() if v != 0}

        # Sort by degree (descending) then lex order
        def sort_key(term):
            return (-len(term[0]), term[0])

        result = []
        for vars_, coeff in sorted(poly.items(), key=sort_key):
            if not vars_:
                result.append(str(coeff))
            else:
                result.append(f"{coeff}*" + '*'.join(vars_))
        return result
