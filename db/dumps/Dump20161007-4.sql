-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 5.196.67.156    Database: cal
-- ------------------------------------------------------
-- Server version	5.5.52-0+deb8u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT  IGNORE INTO `accounts` VALUES (1,'Admin','5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8','admin%40codeandlearn.com',3,2,'1464262190085','1464262190085',0,0),(2,'hirsch','403926033d001b5279df37cbbe5287b7c7c267fa','lol%40lol.lol',1,1,'1474537334716','1474537334716',0,0),(3,'serguei','c9ddb6c25a8f77bd31ba26bb8332c4e1aa2c6778','serguei%40epitech.eu',1,1,'1474626677280','1474626677280',0,0),(4,'test2','c636e8e238fd7af97e2e500f8c6f0f4c0bedafb0','test2%40test.fr',1,1,'1474626720811','1474626720811',0,0),(5,'YellowLight1','51abb9636078defbf888d8457a7c76f85c8f114c','horiot.benjamin%40gmail.con',1,1,'1474630702161','1474630702161',0,0),(6,'Serguei12345','76902c9406dc341cbfda251bf01728f30eec0a41','mail%40mail.fr',1,1,'1474730275696','1474730275696',0,0),(7,'test10','6d48177594b1db78e1684ac2118dc7eafda81c70','test%40test.fr',1,1,'1474730304565','1474730304565',0,0),(8,'Serguei123456','1b8e85ee024a4375de2e4f10f21f1ccc281141ed','serguei%40epitech.de',1,1,'1474733763767','1474733763767',0,0),(9,'YellowLight2','51abb9636078defbf888d8457a7c76f85c8f114c','horiot.benjamin%40gmail.com',1,1,'1474738075111','1474738075111',0,0),(10,'Sheol','42339c579b1f9f3d748b59c65cf4d48640034c7f','tf.sheol%40gmail.com',1,3,'1475394299476','1475394299476',0,0);
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `avatars`
--

LOCK TABLES `avatars` WRITE;
/*!40000 ALTER TABLE `avatars` DISABLE KEYS */;
INSERT  IGNORE INTO `avatars` VALUES (1,'http%3A%2F%2Fwww.freakingnews.com%2Fpictures%2F97500%2FKorean-Elephant-Rocket--97543.jpg'),(2,'https://byuc.files.wordpress.com/2012/07/avat-2.jpg'),(3,'https://chivethethrottle.files.wordpress.com/2012/11/random-t-11_16_12-920-44.jpg?w=920&h=689');
/*!40000 ALTER TABLE `avatars` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `badges`
--

LOCK TABLES `badges` WRITE;
/*!40000 ALTER TABLE `badges` DISABLE KEYS */;
/*!40000 ALTER TABLE `badges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `blog_posts`
--

LOCK TABLES `blog_posts` WRITE;
/*!40000 ALTER TABLE `blog_posts` DISABLE KEYS */;
INSERT  IGNORE INTO `blog_posts` VALUES (1,1,1,1,'Frontend+v2','Bonjour%2C+nous+sommes+fiers+de+vous+annoncer+que+nous+travaillons+actuellement+sur+la+version+v2+de+notre+frontend.%0AJ%27esp%C3%A8re+qu%27il+vous+plaira+%21%0A%0AComme+d%27habitude+n%27h%C3%A9sitez+%C3%A0+nous+donner+des+feedbacks+%21','1474483532486','1474645097512'),(3,1,1,1,'L%27aventure+Code+And+Learn','Bienvenue+sur+notre+blog+et+bienvenue+pour+le+lancement+de+notre+plateforme+%21%0A%0ARejoignez+nous+dans+l%27aventure+Code+And+Learn+%21%21%21','1474630264710','1474645181547'),(4,1,1,2,'C%26L+sur+Facebook','Bonjour+%C3%A0+tous+%21%0A%0APour+ceux+d%27entre+vous+qui+ne+le+sauraient+pas+d%C3%A9j%C3%A0%2C+nous+avons+une+page+Facebook+%3A+https%3A%2F%2Fwww.facebook.com%2FCodeandLearn.%0A%0AJe+vous+invite+%C3%A0+la+like+un+maximum+et+%C3%A0+partager+%21','1474729495103','1474735527982'),(5,1,1,3,'Fix+des+%22%3Cbr+%2F%3E%22','Comme+le+titre+le+pr%C3%A9cise%2C+le+fix+est+deploy%C3%A9+et+tout+les+cours+et+post+blog+touch%C3%A9s+par+ce+bug+sont+d%C3%A9sormais+affich%C3%A9s+de+mani%C3%A8re+correcte+%21%0A%0ALe+retour+du+saut+%C3%A0+la+ligne+fera+surement+plaisir+%C3%A0+la+plupart+%21+%3B%29','1474729736918','1474735507756'),(6,1,1,4,'Windows+Phone','Tout+le+monde+travaille','1474734965487','1474734965487');
/*!40000 ALTER TABLE `blog_posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `blog_posts_category`
--

LOCK TABLES `blog_posts_category` WRITE;
/*!40000 ALTER TABLE `blog_posts_category` DISABLE KEYS */;
INSERT  IGNORE INTO `blog_posts_category` VALUES (1,'G%C3%A9n%C3%A9rale'),(2,'Communication'),(3,'Mise+%C3%A0+jour'),(5,'Categorie');
/*!40000 ALTER TABLE `blog_posts_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `blog_posts_comments`
--

LOCK TABLES `blog_posts_comments` WRITE;
/*!40000 ALTER TABLE `blog_posts_comments` DISABLE KEYS */;
INSERT  IGNORE INTO `blog_posts_comments` VALUES (1,1,1,'Et+suivez+nous+sur+les+r%C3%A9seaux+sociaux+%21','1474483637688','1475177224863');
/*!40000 ALTER TABLE `blog_posts_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `code_templates`
--

LOCK TABLES `code_templates` WRITE;
/*!40000 ALTER TABLE `code_templates` DISABLE KEYS */;
INSERT  IGNORE INTO `code_templates` VALUES (1,2,'check.sh','%23%21%2Fbin%2Fsh%0A%0Aexit+%24%3F'),(2,3,'check.sh','%23%21%2Fbin%2Fsh%0A%0Aexit+%24%3F'),(3,4,'check.sh','%23%21%2Fbin%2Fsh%0A%0Aexit+%24%3F');
/*!40000 ALTER TABLE `code_templates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `codes`
--

LOCK TABLES `codes` WRITE;
/*!40000 ALTER TABLE `codes` DISABLE KEYS */;
INSERT  IGNORE INTO `codes` VALUES (1,1,'main.c','%23include+%3Cstdio.h%3E%0A%23include+%3Cstdlib.h%3E%0A%0Aint+main%28%29%0A%7B%0A++++printf%28%22Hello+World%5Cn%22%29%3B%0A++++return+0%3B%0A%7D','1474497118621','1475392859868');
/*!40000 ALTER TABLE `codes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `course_moderation`
--

LOCK TABLES `course_moderation` WRITE;
/*!40000 ALTER TABLE `course_moderation` DISABLE KEYS */;
INSERT  IGNORE INTO `course_moderation` VALUES (8,1,''),(14,1,''),(15,0,''),(16,1,''),(17,0,''),(18,0,'');
/*!40000 ALTER TABLE `course_moderation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT  IGNORE INTO `courses` VALUES (14,1,1,3,'Hello+World','Bonjour+%C3%A0+tous%2C+aujourd%27hui+nous+allons+cr%C3%A9er+un+simple+programme+en+C+nous+affichant+un+%22Hello+World%22%0A%0AVoici+donc+le+code+%C3%A0+faire+%3A%0A%0A%23include+%3Cstdio.h%3E%0A%23include+%3Cstdlib.h%3E%0A%0Aint+main%28%29%0A%7B%0A+++printf%28%22Hello+World%22%29%3B%0A%7D%0A%0AVoil%C3%A0+il+ne+vous+reste+plus+qu%27%C3%A0+compiler+et+le+tour+est+jou%C3%A9+%21','1474645473004','1474645473004'),(15,1,1,2,'Java+-+Partie+1','Bonjour+%C3%A0+tous+%21%0A%0ABienvenue+dans+mon+cours+de+programmation+en+Java.+C%27est+un+langage+tr%C3%A8s+utilis%C3%A9%2C+notamment+par+un+grand+nombre+de+programmeurs+professionnels%2C+ce+qui+en+fait+un+langage+incontournable+actuellement.%0A%0AVoici+les+caract%C3%A9ristiques+de+Java+en+quelques+mots+%3A%0A%0AJava+est+un+langage+de+programmation+moderne+d%C3%A9velopp%C3%A9+par+Sun+Microsystems+%28aujourd%27hui+rachet%C3%A9+par+Oracle%29.+Il+ne+faut+surtout+pas+le+confondre+avec+JavaScript+%28langage+de+scripts+utilis%C3%A9+principalement+sur+les+sites+web%29%2C+car+Java+n%27a+rien+%C3%A0+voir.%0AUne+de+ses+plus+grandes+forces+est+son+excellente+portabilit%C3%A9+%3A+une+fois+votre+programme+cr%C3%A9%C3%A9%2C+il+fonctionnera+automatiquement+sous+Windows%2C+Mac%2C+Linux%2C+etc.%0A%0ALa+suite+au+prochain+num%C3%A9ro+%21','1474645739345','1474645739345'),(16,1,1,1,'C%23+-+Pr%C3%A9sentation','C%23+est+un+langage+de+programmation+orient%C3%A9e+objet%2C+fortement+typ%C3%A9%2C+d%C3%A9riv%C3%A9+de+C+et+C%2B%2B%2C+ressemblant+au+langage+Java2.+Il+est+utilis%C3%A9+pour+d%C3%A9velopper+des+applications+web%2C+ainsi+que+des+applications+de+bureau%2C+des+services+web%2C+des+commandes%2C+des+widgets+ou+des+biblioth%C3%A8ques+de+classes2.+En+C%23+une+application+est+un+lot+de+classes+o%C3%B9+une+des+classes+comporte+une+m%C3%A9thode+Main%2C+comme+cela+se+fait+en+Java2.%0A%0AC%23+est+destin%C3%A9+%C3%A0+d%C3%A9velopper+sur+la+plateforme+.NET%2C+une+pile+technologique+cr%C3%A9e+par+Microsoft+pour+succ%C3%A9der+%C3%A0+COM.%0A%0ALes+ex%C3%A9cutables+en+C%23+sont+subdivis%C3%A9s+en+assemblies%2C+en+namespaces%2C+en+classes+et+en+membres+de+classe3.+Un+assembly+est+la+forme+compil%C3%A9e%2C+qui+peut+%C3%AAtre+un+programme+ou+une+biblioth%C3%A8que+de+classes.+Un+assembly+contient+le+code+ex%C3%A9cutable+en+MSIL%2C+ainsi+que+les+symboles.+Le+code+MSIL+est+traduit+en+langage+machine+au+moment+de+l%27ex%C3%A9cution+par+la+fonction+just-in-time+de+la+plateforme+.NET3.%0A%0AC%23+est+destin%C3%A9+%C3%A0+d%C3%A9velopper+sur+la+plateforme+.NET.+Le+c%C5%93ur+de+cette+pile+technologique+est+le+framework+.NET%2C+compos%C3%A9+de2%3A%0A%0ALes+environnements+ASP.NET+et+Winforms+qui+servent+%C3%A0+ex%C3%A9cuter+des+applications+web%2C+resp.+de+bureau+con%C3%A7us+pour+la+plateforme+.NET2.%0AUne+biblioth%C3%A8que+de+classes+qui+permet+de+manipuler+des+fichiers%2C+manipuler+des+tableaux+ou+des+structures+en+arbres%2C+acc%C3%A9der+%C3%A0+Internet%2C+cr%C3%A9er+des+interfaces+graphiques%2C+acc%C3%A9der+%C3%A0+des+bases+de+donn%C3%A9es%2C+acc%C3%A9der+au+registre+Windows+et+beaucoup+d%27autres+choses.+La+plupart+des+fonctionnalit%C3%A9s+sont+offertes+par+des+classes+de+l%27espace+de+noms+System2.%0ALe+Common+Language+Runtime+%28abr.+CLR%29+est+le+runtime+utilis%C3%A9+par+les+langages+de+la+plateforme+.NET+%28C%23%2C+Visual+Basic+.NET%2C+J%23%2C+etc.%29%2C+les+services+fournit+par+la+CLR+sont+le+lancement+et+l%27ex%C3%A9cution+de+programmes%2C+le+ramasse-miettes+et+la+gestion+d%27exceptions.+Un+programme+pour+la+plateforme+.NET+est+tout+d%27abord+compil%C3%A9+en+une+forme+interm%C3%A9diaire%2C+le+MSIL%2C+puis+ce+code+MSIL+est+transform%C3%A9+en+code+machine+qui+sera+ex%C3%A9cut%C3%A9+par+la+CLR.+Ce+code+machine+est+appel%C3%A9+managed+code+parce+que+son+ex%C3%A9cution+est+sous+le+contr%C3%B4le+de+la+CLR2.%0AUn+autre+produit+de+la+plateforme+.NET+est+l%27environnement+de+d%C3%A9veloppement+Visual+Studio+.NET%2C+outil+g%C3%A9n%C3%A9ralement+utilis%C3%A9+pour+programmmer+en+C%23.','1474645924267','1474645924267'),(17,1,1,4,'Commencer+a+apprendre+le+python','Voici+comment+apprendre+le+python','1474734872817','1474734872817'),(18,1,1,2,'Le+Java+c%27est+pas+bien','Non+je+rigole%2C+le+JAVA+c%27est+vraiment+bien.','1474735008898','1474735008898');
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `courses_comments`
--

LOCK TABLES `courses_comments` WRITE;
/*!40000 ALTER TABLE `courses_comments` DISABLE KEYS */;
INSERT  IGNORE INTO `courses_comments` VALUES (1,18,1,'Je+suis+d%27accord.','1474735136022','1474735136022'),(2,16,1,'J%27aime+cet+article','1474738314591','1474738314591');
/*!40000 ALTER TABLE `courses_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `exercises`
--

LOCK TABLES `exercises` WRITE;
/*!40000 ALTER TABLE `exercises` DISABLE KEYS */;
INSERT  IGNORE INTO `exercises` VALUES (1,1,14,'Affiche+un+Hello+World','Avec+la+technique+pr%C3%A9sent%C3%A9e+dans+le+cours%2C+Affichez+un+Hello+World%21%0D%0A%0D%0AVotre+programme+affichera+exactement+cette+string%3A+%22Hello+World%22.+%28sans+les+guillemets%29',10),(2,1,1,'New+Exercise+22%2F8%2F2016+11h30m15s','New+Exercise+22%2F8%2F2016+11h30m15s%0A%0AWrite+instructions+here.',10),(3,2,1,'New+Exercise+22%2F8%2F2016+17h21m10s','New+Exercise+22%2F8%2F2016+17h21m10s%0A%0AWrite+instructions+here.',10),(4,1,6,'New+Exercise+23%2F8%2F2016+13h13m43s','New+Exercise+23%2F8%2F2016+13h13m43s%0A%0AWrite+instructions+here.',10);
/*!40000 ALTER TABLE `exercises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `exercises_comments`
--

LOCK TABLES `exercises_comments` WRITE;
/*!40000 ALTER TABLE `exercises_comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercises_comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `exercises_corrections`
--

LOCK TABLES `exercises_corrections` WRITE;
/*!40000 ALTER TABLE `exercises_corrections` DISABLE KEYS */;
INSERT  IGNORE INTO `exercises_corrections` VALUES (1,2,'Correction%3A+echo+%22Hello+World%22','1474536617335'),(2,3,'Correction%3A+echo+%22Hello+World%22','1474557673037'),(3,4,'Correction%3A+echo+%22Hello+World%22','1474629242088');
/*!40000 ALTER TABLE `exercises_corrections` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `exercises_moderation`
--

LOCK TABLES `exercises_moderation` WRITE;
/*!40000 ALTER TABLE `exercises_moderation` DISABLE KEYS */;
INSERT  IGNORE INTO `exercises_moderation` VALUES (1,1,' '),(2,0,'Content+not+reviewed+yet'),(3,0,'Content+not+reviewed+yet'),(4,0,'Content+not+reviewed+yet');
/*!40000 ALTER TABLE `exercises_moderation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `forum_category`
--

LOCK TABLES `forum_category` WRITE;
/*!40000 ALTER TABLE `forum_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `forum_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `groups`
--

LOCK TABLES `groups` WRITE;
/*!40000 ALTER TABLE `groups` DISABLE KEYS */;
INSERT  IGNORE INTO `groups` VALUES (1,'member',10),(2,'moderator',30),(3,'administrator',50);
/*!40000 ALTER TABLE `groups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `languages`
--

LOCK TABLES `languages` WRITE;
/*!40000 ALTER TABLE `languages` DISABLE KEYS */;
INSERT  IGNORE INTO `languages` VALUES (1,'C%23'),(2,'JAVA'),(3,'C'),(4,'Python');
/*!40000 ALTER TABLE `languages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `locales`
--

LOCK TABLES `locales` WRITE;
/*!40000 ALTER TABLE `locales` DISABLE KEYS */;
INSERT  IGNORE INTO `locales` VALUES (1,'FR'),(2,'EN');
/*!40000 ALTER TABLE `locales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `scripts`
--

LOCK TABLES `scripts` WRITE;
/*!40000 ALTER TABLE `scripts` DISABLE KEYS */;
INSERT  IGNORE INTO `scripts` VALUES (1,1,'%23%21%2Fbin%2Fbash%0D%0Acd+%2Fhome%0D%0A%0D%0Aecho+%22Compilation+de+votre+programme...%22%0D%0Agcc+-W+-Wall+-Werror+main.c%0D%0A%0D%0Aif+%5B+%24%3F+-eq+1+%5D%3B+then%0D%0A+++echo+%22Erreur+de+compilation.%22%0D%0A+++echo+%22Note%3A+0%22%0D%0A+++exit+0%0D%0Afi%0D%0A%0D%0Aecho+%22Compilation+r%C3%A9ussie%21%22%0D%0Aecho+%22%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%22%0D%0A%0D%0Aecho+%22Ex%C3%A9cution+du+programme...%22%0D%0A.%2Fa.out+%3E+output%0D%0A%0D%0Aecho+%22R%C3%A9sultat+de+l%27ex%C3%A9cution%3A%22%0D%0Acat+output%0D%0A%0D%0Aecho+%22%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%22%0D%0A%0D%0Aecho+%22Hello+World%22+%3E+input%0D%0A%0D%0AVAL%3D%24%28diff+input+output%29%0D%0A%0D%0Aif+%5B+%24%7B%23VAL%7D+-eq+0+%5D%3B+then%0D%0A+++echo+%22Exercice+r%C3%A9ussi+%3A%29%22%0D%0A+++echo+%22Note%3A+1%22%0D%0A+++exit+1%0D%0Afi%0D%0A%0D%0Aecho+%22Diff%C3%A9rence+sur+la+sortie+attendue+%3A%28+K.O.%22%0D%0Aecho+%22Log%3A%22%0D%0Aecho+%24VAL%0D%0Aecho+%22%3D%3D%3D%3D%22%0D%0Aecho+%22Note%3A+0%22%0D%0Aexit+0%0D%0A%23%21%2Fbin%2Fbash%0D%0Acd+%2Fhome%0D%0A%0D%0Aecho+%22Compilation+de+votre+programme...%22%0D%0Agcc+-W+-Wall+-Werror+main.c%0D%0A%0D%0Aif+%5B+%24%3F+-eq+1+%5D%3B+then%0D%0A+++echo+%22Erreur+de+compilation.%22%0D%0A+++echo+%22Note%3A+0%22%0D%0A+++exit+0%0D%0Afi%0D%0A%0D%0Aecho+%22Compilation+r%C3%A9ussie%21%22%0D%0Aecho+%22%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%22%0D%0A%0D%0Aecho+%22Ex%C3%A9cution+du+programme...%22%0D%0A.%2Fa.out+%3E+output%0D%0A%0D%0Aecho+%22R%C3%A9sultat+de+l%27ex%C3%A9cution%3A%22%0D%0Acat+output%0D%0A%0D%0Aecho+%22%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%3D%22%0D%0A%0D%0Aecho+%22Hello+World%22+%3E+input%0D%0A%0D%0AVAL%3D%24%28diff+input+output%29%0D%0A%0D%0Aif+%5B+%24%7B%23VAL%7D+-eq+0+%5D%3B+then%0D%0A+++echo+%22Exercice+r%C3%A9ussi+%3A%29%22%0D%0A+++echo+%22Note%3A+1%22%0D%0A+++exit+1%0D%0Afi%0D%0A%0D%0Aecho+%22Diff%C3%A9rence+sur+la+sortie+attendue+%3A%28+K.O.%22%0D%0Aecho+%22Log%3A%22%0D%0Aecho+%24VAL%0D%0Aecho+%22%3D%3D%3D%3D%22%0D%0Aecho+%22Note%3A+0%22%0D%0Aexit+0','1474536616746','1474536616746'),(2,3,'%23%21%2Fbin%2Fbash%0A%0Aexit+%24%3F','1474557672516','1474557672516'),(3,4,'%23%21%2Fbin%2Fbash%0A%0Aexit+%24%3F','1474629241938','1474629241938');
/*!40000 ALTER TABLE `scripts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_exercises`
--

LOCK TABLES `user_exercises` WRITE;
/*!40000 ALTER TABLE `user_exercises` DISABLE KEYS */;
INSERT  IGNORE INTO `user_exercises` VALUES (1,1,1),(2,1,2),(6,2,1),(7,2,2);
/*!40000 ALTER TABLE `user_exercises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users_badges`
--

LOCK TABLES `users_badges` WRITE;
/*!40000 ALTER TABLE `users_badges` DISABLE KEYS */;
/*!40000 ALTER TABLE `users_badges` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-07 16:30:50
