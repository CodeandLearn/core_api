# Per-line contribution (update 12/06/2016)
```
git ls-files -z | xargs -0n1 git blame -w | perl -n -e '/^.*?\((.*?)\s+[\d]{4}/; print $1,"\n"' | sort -f | uniq -c | sort -n
```
* 14 HallElouia
* 19 Sithis
* 5780 Teddy Fontaine

# Contribution users
## Raphael Morand (HallElouia)
    * Exercise plugin

## Fabien Casoni (Sithis)
    * Course plugin
    * Language plugin

## Teddy Fontaine (Sheol)
    * Core
    * Account plugin
    * Blog plugin