#!/usr/bin/env python3
import matplotlib.pyplot as plt

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
    produit = 1
    for i in range(1,n + 1) :
        produit *= i
    return produit

def ListePoints(L):
    ListeAbsice = [i for i in range(len(L))]
    ListeOrdonnée = []
    for i in range(len(L)):
        print(i)
        if(i != 0):
            ListeOrdonnée.append(L[i]/i)
        else:
            ListeOrdonnée.append(0)
    print(ListeAbsice,ListeOrdonnée)
    return (ListeAbsice, ListeOrdonnée)

L = []
print(ListePoints(L))
(x_points, y_points)  = ListePoints(L)
plt.scatter(x_points, y_points, color='blue', marker='o', label='Points')

# Ajouter des titres et des étiquettes
plt.title("représention du taux d'erreur en fonction du nombre de flottant testé")
plt.xlabel("nombre de flottants testés")
plt.ylabel("Taux d'erreur")

# Afficher la légende
plt.legend()

# Afficher le graphe
plt.show()