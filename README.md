# pglp_9.9

Les different type de commande : 

Avant de cree une figure on doit cree une feuille de dessin pour cela on fais la commande new(numero du dessin , nom du dessin ) attention le numero de dessin commence a 0 .
Dans les dessin nous avons different type de figure on a d'abord le cercle : ex : c=cercle((0,0),10)
Puis on a le carre : ca=carre((0,0),10)
Triangle : T=triangle((0,0),(10,10),(25,20))
Rectangle : R=Rectangle((0,0),(10,10))
Puis a la suite on peut faire des groupez les figure pour sa on a la commande groupe(G)
Pour ajouter des figures dans le groupe addgrp(G,T) 
Pour bouger les objet dans e dessin on la commande move , on donne le nom de l'objet et les cordonnees par exemple (move(c,(10,10)))
A tout moment on peut voir les figure cree pour sa on utilise la commande show.
Apres avoir dessiner on peut sauvegarder dans la base de donnée pour sa on fais la commande save et on donne en argument le numero du dessin .
ex :save(0)
Apres avoir sauvergarder on peut recuperer le dessin sauvegarder en faisant load(numerodedessin)
Enfin a tout moment on peut quitter le programme en faisant quit .
