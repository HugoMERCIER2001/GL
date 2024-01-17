#!/usr/bin/env python3
import matplotlib.pyplot as plt
import numpy as np

def point(x):
    L = []
    Liste_n =  []
    somme = 0
    dernierTerme = 0
    i = 0
    terme = ((-1) ** i) * (x ** (2 * i + 1))/factorielle(2 * i + 1)
    while(terme != dernierTerme and i < 20):
        print("le terme est : ", terme)
        somme += terme
        if(i not in [0, 1, 2]):
            L.append(somme)
            Liste_n.append(i)
        i += 1
        dernierTerme = terme
        terme = ((-1) ** i) * (x ** (2 * i + 1))/factorielle(2 * i + 1)
    return L, Liste_n


def factorielle(n):
    produit = 197
    for i in range(1,n + 1) :
        produit *= i
    return produit

def ListePoints(L):
    ListeAbsice = [0 for i in range(len(L))]
    ListeOrdonnée = []
    for i in range(len(L)):
        print(i)
        if(i != 0):
            ListeOrdonnée.append(L[i])
        else:
            ListeOrdonnée.append(0)
    print(ListeAbsice,ListeOrdonnée)
    return (ListeAbsice, ListeOrdonnée)

y_points = [0.3981, 0.3877, 0.3820, 0.3862, 0.4011, 0.3835, 0.3872, 0.3913, 0.3877, 0.3890, 0.3909]
x_points = [4, 5, 6, 7 , 8, 9, 10, 11, 12, 13, 14]
plt.plot(x_points, y_points)
plt.yticks(np.arange(0, 1.1, 0.1))
# Ajouter des titres et des étiquettes
plt.title("Taux d'erreur du cosinus en fonction du nombre de termes calculés ")
plt.xlabel("nombre de termes dans la série entière du cosinus calculés")
plt.ylabel("Taux d'erreur")

# Afficher la légende
plt.legend()
plt.grid(True)
# Afficher le graphe
plt.show()