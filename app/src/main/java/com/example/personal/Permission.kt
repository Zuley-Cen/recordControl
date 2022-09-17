package com.example.personal

import java.time.LocalDate

data class Permission(val employee: Employee,
                      val date: LocalDate,
                      val justification: String)

// cuando se crea un objeto hay dependencia lo cual indica un alto acoplamiento