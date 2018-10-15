package com.commerce.produit.persistence.dao;

import com.commerce.produit.persistence.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@Transactional
@Component
public class DbSeeder implements CommandLineRunner {

    @Autowired
    private ProduitDao produitDao;

    @Override
    public void run(final String... args) throws Exception {

        Stream.of(
                new Produit(
                        "Bougie fonctionnant au feu",
                        "bougie qui fonctionne comme une ampoule mais sans électricité !",
                        "https://s3.eu-west-3.amazonaws.com/oc-images-cours/bougies.jpg",
                        22.0),
                new Produit(
                        "Chaise pour s'assoir",
                        "Chaise rare avec non pas 1 ni 2 mais 3 pieds",
                        "https://s3.eu-west-3.amazonaws.com/oc-images-cours/chaise.jpg",
                        95.0),
                new Produit(
                        "Cheval pour nains",
                        "Ce cheval ne portera certainement pas blanche neige, mais sans problème les nains",
                        "https://s3.eu-west-3.amazonaws.com/oc-images-cours/cheval.jpg",
                        360.0),
                new Produit(
                        "Coq of steel, le superman des volailles",
                        "Ne passe pas au four",
                        "https://s3.eu-west-3.amazonaws.com/oc-images-cours/coq.jpg",
                        620.0),
                new Produit(
                        "Flacon à frotter avec un génie dedans",
                        "Vous donne droit à l'équivalent de 3/0 voeux",
                        "https://s3.eu-west-3.amazonaws.com/oc-images-cours/flacon.jpg",
                        1200.0),
                new Produit(
                        "Horloge quantique",
                        "Donne l'heure, les minutes et même les secondes. Ne fait pas de café",
                        "https://s3.eu-west-3.amazonaws.com/oc-images-cours/horloge.jpg",
                        180.0),
                new Produit(
                        "Table d'opération pour Hamsters",
                        "Pour réaliser vos opérations chirugicales sur votre Hamster!",
                        "https://s3.eu-west-3.amazonaws.com/oc-images-cours/table.jpg",
                        210.0),
                new Produit(
                        "Vase ayant appartenu a Zeus", "Risque de choc électrique",
                        "https://s3.eu-west-3.amazonaws.com/oc-images-cours/vase.jpg",
                        730.0)
        ).forEach(produitDao::save);
/*        ).forEach(produit -> produitDao.save(produit));

        this.produitDao.save(new Produit("Bougie fonctionnant au feu",
                "bougie qui fonctionne comme une ampoule mais sans électricité !",
                "https://s3.eu-west-3.amazonaws.com/oc-images-cours/bougies.jpg", 22.0));
        this.produitDao.save(
                new Produit("Chaise pour s'assoir", "Chaise rare avec non pas 1 ni 2 mais 3 pieds",
                        "https://s3.eu-west-3.amazonaws.com/oc-images-cours/chaise.jpg", 95.0));
        this.produitDao.save(new Produit("Cheval pour nains",
                "Ce cheval ne portera certainement pas blanche neige, mais sans problème les nains",
                "https://s3.eu-west-3.amazonaws.com/oc-images-cours/cheval.jpg", 360.0));
        this.produitDao.save(new Produit("Coq of steel, le superman des volailles",
                "Ne passe pas au four", "https://s3.eu-west-3.amazonaws.com/oc-images-cours/coq.jpg", 620.0));
        this.produitDao.save(new Produit("Flacon à frotter avec un génie dedans",
                "Vous donne droit à l'équivalent de 3/0 voeux",
                "https://s3.eu-west-3.amazonaws.com/oc-images-cours/flacon.jpg", 1200.0));
        this.produitDao.save(new Produit("Horloge quantique",
                "Donne l'heure, les minutes et même les secondes. Ne fait pas de café",
                "https://s3.eu-west-3.amazonaws.com/oc-images-cours/horloge.jpg", 180.0));
        this.produitDao.save(new Produit("Table d'opération pour Hamsters",
                "Pour réaliser vos opérations chirugicales sur votre Hamster!",
                "https://s3.eu-west-3.amazonaws.com/oc-images-cours/table.jpg", 210.0));
        this.produitDao.save(new Produit("Vase ayant appartenu a Zeus", "Risque de choc électrique",
                "https://s3.eu-west-3.amazonaws.com/oc-images-cours/vase.jpg", 730.0));*/
    }
}
