# Array Java

## RubricaTelefonica

Si realizzi la classe `RubricaTelefonica` che viene utilizzata per mantenere e ricercare le informazioni relative ad amici e conoscenti. La classe dovrà memorizzare all’interno di un array (opportunamente dimensionato) le diverse `SchedaPersona` ed implementare i seguenti metodi.

Si definisca una interface `Rubrica` con i metodi previsti:

> - `boolean insert(SchedaPersona s)`
Inserisce all’interno dell’array la SchedaPersona ricevuta come parametro;
ritorna true nel caso in cui l’inserimento sia andato a buon fine, false in caso contrario (ad esempio si è raggiunta la capacità massima dell’array e di conseguenza non è più possibile inserire nuovi dati, oppure si cerca di inserire una scheda già presente);

> - `SchedaPersona[] search(String s)`
Restituisce tutte le schede che contengono la stringa ricevuta come parametro;

> - `String toString()`
Costruisce una rappresentazione stampabile della rubrica;

> - `boolean delete(SchedaPersona s)`
Elimina la scheda ricevuta come parametro; ritorna true in caso di cancellazione avvenuta con successo false altrimenti (la scheda non esiste).

Si modifichi la classe `SchedaPersona` inserendo il seguente **costruttore** per inizializzare i dati della classe:

- `public SchedaPersona(String nome, String indirizzo, String numero)`

Si utilizzi poi la classe JUnit `RubricaTelefonicaTest` per testare la classe implementata.

### Suggerimenti:

- È opportuno fare in modo che l’array utilizzato internamente alla classe `RubricaTelefonica` resti “compatto”, ovvero che tutte le schede si trovino consecutivamente a partire dalla posizione 0.
In caso di cancellazione di una scheda posta in una posizione intermedia, è opportuno riempire la posizione che verrebbe a liberarsi con la scheda posta in coda all’array;

- Dimensionare l’array contente le schede della rubrica tramite un
parametro ricevuto nel costruttore della classe `RubricaTelefonica`.
