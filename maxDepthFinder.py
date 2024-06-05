import csv 
import itertools
from collections import defaultdict

def read_file(file_name):
    caixas = []
    with open(file_name, 'r') as file:
        reader = csv.reader(file, delimiter = '')
        for row in reader:
            caixa = [float(num) for num in row]
            caixas.append(caixa)
    return caixas


def generate_exchange(caixa):
    return list(itertools.permutations(caixa))


def fits_inside(caixa1, caixa2):
    return all(dim1 < dim2 for dim1, dim2 in zip(caixa1, caixa2))


def build_graph(caixas):
    graph = defaultdict(list)
    exchanges = [generate_exchange(caixa) for caixa in caixas]
    for i, exchanges_i in enumerate(exchanges):
        for j, exchanges_j in enumerate(exchanges):
            if i != j:
                for ex_i in exchanges_i:                                  
                    for ex_j in exchanges_j:
                        if fits_inside(ex_i, ex_j):
                            graph[i].append(j)
    return graph


def find_longest_depth(graph):
    def DFS(v, visited, dp):
        if visited[v]:
            return dp[v]
        visited[v] = True
        max_len = 1
        for neighbor in graph[v]:
            max_len = max(max_len, 1 + DFS(neighbor, visited, dp))
        dp[v] = max_len
        return max_len

    n = len(graph)
    visited = [False] * n
    dp = [0] * n
    max_path = 0

    for v in range(n):
        if not visited[v]:
            max_path = max(max_path, DFS(v, visited, dp)) 
