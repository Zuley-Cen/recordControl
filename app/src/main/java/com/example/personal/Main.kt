package com.example.personal

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

fun main(){
    val period = Period(initialDate = LocalDate.parse("2022-08-10"),
        finalDate = LocalDate.parse("2022-12-15"), description = "agosto-diciembre")

    val employee = Employee(id= 1, fullName = "Claudia Victoria Santiago",
        academicLevel = AcademicLevel.MASTER, curp= "VISC891204MOCALL02",
        dateOfAdmission = LocalDate.parse("2017-07-17"), budgetKey = "MAR457" )

    val schedule = Schedule.Builder(employee = employee, period = period)
        .addOne(
            Schedule.Detail(
                dayOfWeek = DayOfWeek.MONDAY, checkIn = LocalTime.parse("10:00"),
                checkOut = LocalTime.parse("17:00:00")
            )
        )
        .addOne(
            Schedule.Detail(
                dayOfWeek = DayOfWeek.TUESDAY, checkIn = LocalTime.parse("08:00"),
                checkOut = LocalTime.parse("15:00:00")
            )
        )
        .addOne(
            Schedule.Detail(
                dayOfWeek = DayOfWeek.FRIDAY, checkIn = LocalTime.parse("09:00"),
                checkOut = LocalTime.parse("16:00:00")
            )
        )
        .addOne(
            Schedule.Detail(
                dayOfWeek = DayOfWeek.SATURDAY, checkIn = LocalTime.parse("09:00"),
                checkOut = LocalTime.parse("16:00:00")
            )
        )
        .build()

    val permissions = listOf(
        Permission(employee = employee, LocalDate.parse("2022-09-09"),
            justification = "Cita medica")
    )

    val checksInOut= ArrayList<CheckInOut>()

    checksInOut.add(
        CheckInOut(employee = employee,date= LocalDate.parse("2022-09-05"),
            checkIn = LocalTime.parse("10:14:00"),
            checkOut = LocalTime.parse("17:00:00"))
    )
    checksInOut.add(
        CheckInOut(employee = employee,date= LocalDate.parse("2022-09-06"),
            checkIn = LocalTime.parse("08:24:00"),
            checkOut = LocalTime.parse("15:00:00"))
    )
    checksInOut.add(
        CheckInOut(employee = employee,date= LocalDate.parse("2022-09-09"),
            checkIn = LocalTime.parse("10:24:00"),
            checkOut = LocalTime.parse("16:00:00"))
    )

    val incident = Incident(employee = employee, currentSchedule = schedule,
        checksInOut = checksInOut, permissions= permissions,
        initialDate = LocalDate.parse("2022-09-05"),
        finalDate = LocalDate.parse("2022-09-10"))

    println("Employee ${employee.fullName} has ${incident.getAbsences()} absences")
}