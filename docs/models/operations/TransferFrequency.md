# TransferFrequency

The frequency with which the available amount on the balance will be settled to the configured transfer
destination.

* `daily` — Every business day
* `twice-a-week` — Every Tuesday and Friday
* `every-monday` — Every Monday
* `every-tuesday` — Every Tuesday
* `every-wednesday` — Every Wednesday
* `every-thursday` — Every Thursday
* `every-friday` — Every Friday
* `twice-a-month` — On the first and the fifteenth of the month
* `monthly` — On the first of the month
* `never` — Automatic settlements are paused for this balance

Settlements created during weekends or on bank holidays will take place on the next business day.


## Values

| Name              | Value             |
| ----------------- | ----------------- |
| `DAILY`           | daily             |
| `TWICE_A_WEEK`    | twice-a-week      |
| `EVERY_MONDAY`    | every-monday      |
| `EVERY_TUESDAY`   | every-tuesday     |
| `EVERY_WEDNESDAY` | every-wednesday   |
| `EVERY_THURSDAY`  | every-thursday    |
| `EVERY_FRIDAY`    | every-friday      |
| `TWICE_A_MONTH`   | twice-a-month     |
| `MONTHLY`         | monthly           |
| `NEVER`           | never             |