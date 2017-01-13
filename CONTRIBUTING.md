# Per-line contribution (update 04/12/2016)
```
git ls-files -z | xargs -0n1 git blame -w | perl -n -e '/^.*?\((.*?)\s+[\d]{4}/; print $1,"\n"' | sort -f | uniq -c | sort -n
```
```
     30 Fabien Casoni
    338 Raphael Morand
  16630 Teddy Fontaine
```

# Contribution users
## Fabien Casoni (Sithis)
    * Language plugin

## Raphael Morand (HallElouia)
    * Exercise plugin
    * Feedback plugin

## Teddy Fontaine (Sheol)
    * Core
    * Account plugin
    * Course plugin
    * Blog plugin
    * Server plugin
    * ServerCom plugin
    * Badge plugin
    * History plugin
    * Key plugin
    * Forum plugin