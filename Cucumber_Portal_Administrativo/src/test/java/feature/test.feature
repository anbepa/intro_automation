
Feature: Se requiere la creacion de un portal administrativo

  @Browser
  Scenario Outline: Crear un perfil nuevo
    Given El perfil con  <Codigo>  no debe estar creado en la funcion perfiles
    When  llenar el formulario de creacion con codigo <Codigo> y Nombre de  perfil <Perfil> gurdando los cambios
    Then  Mensaje informativo de  creacion  exitosa
    Examples:
      | Codigo                   | Perfil         |
      | "67676767"               |"PerfilColombia"|

  @test
  Scenario: Dar accesos a perfil segun  modulos disponibles
    When  Asociar funciones a cada perfil

      | Perfil                    |Modulo           |
      | 67676767                  |Migraciones      |
      | 67676767                  |Administrativo	|

  @test
  Scenario Outline: Consultar y Modificar un usuario existente modificando el Perfil
    Given El usuario <Usuario> debe estar creado en la funcion Usuarios y el perfil <Perfil> debe estar creado
    When  Editar el campo Perfil <Perfil> y guardar la edicion
    Then  Mensaje informativo de   modificacion
    Then  Solo debe permitir el acceso de acuerdo al nuevo perfil
    Examples:
      | Usuario   | Perfil  |
      | "ABERNAL" |"67676767" |

  @test
  Scenario Outline: Consultar y Modificar un usuario existente modificando el estado
    Given El usuario <Usuario> debe estar creado en la funcion Usuarios
    When  Editar el campo Estado <Estado>
    Then  Mensaje informativo
    Then  No debe permitir el ingreso
    Examples:
      | Usuario   | Estado    |
      | "ABERNAL" |"Inactivo" |



 @CambiosGenerales
  Scenario Outline: Realizar Cambios Generales Cliente Empresa y verificar que  los cambios sean correctos modulo consulta
    Given La empresa <tipoIdentificacion> <NumeroIdentificacion> debe existir
    When  Modificar la razón social <RazonSocial> el tipo <Tipo> y número de identificación <Numero>
    And   Modificar dirección <Direccion> y correo electronico  <Correo>  e ingresar sedes <Sedes>
    Then  Mensaje informativo de  modificacion  exitosa
    Then Consultar datos con fecha inicial <FechaI> y fecha final <FechaF> deben estar registrados
    Examples:
      |FechaI          |FechaF    | RazonSocial                |Tipo                           |Numero                       |Direccion                      |Correo                         |Sedes            |tipoIdentificacion          |NumeroIdentificacion|
      | "17062020"     | "1706"   | "Ferreterias & Tornillos"  |"NIT de persona jurídica"      | "8604667181"                | "calle 10 # 54-67"            |"leonardo@bancodebogota.com"         | "Usaquen"       | "NIT de persona jurídica"  |"8604667181"        |


  @CambiosBeneficiario
  Scenario Outline: Realizar modificaciones cambios Identificación a  Beneficiario
    Given La empresa con  tipo  <tipoIdentificacion> y  numero <NumeroIdentificacion> debe estar creada
    When  Modificar el tipo <Tipo> y numero de identificacion <Identificacion> y el numero de celular <Celular>
    Then  Mensaje informativo de  modificacion beneficiario
    Then Consultar datos con fechas inicial <FechaI> y fecha final <FechaF> deben estar registrados
    Examples:
      |FechaI          |FechaF    | tipoIdentificacion      |NumeroIdentificacion|   Tipo                     |Identificacion |Celular      |
      | "29052020"     | "2905"   | "Cedula de ciudadanía"  |"1234567890"        |  "Cedula de ciudadanía"    | "1234567890"  | "3013633400"|



  @CambiosCuentas
  Scenario Outline: Realizar Cambios de cuentas
    Given La empresa con  tipo  <tipoIdentificacion> y  numero <NumeroIdentificacion>  y convenio <Convenio> debe existir
    When  Modificar la  cuenta primaria  por una nueva cuenta <Cuenta> seleccionando un tipo de cuenta <Tipo>
    Then  Mensaje informativo de  modificacion cuenta
    Then Consultar datos con fechas inicial <FechaI> y fecha final <FechaF>
    Examples:
      |FechaI          |FechaF    | tipoIdentificacion         |NumeroIdentificacion|   Convenio      |Cuenta        |Tipo               |
      | "16062020"     | "1606"   | "NIT de persona jurídica"  |"8604667181"        |  "EFECTIVA 1"   | "0019846906" | "Cuenta Ahorro"   |
      | "16062020"     | "1606"   | "NIT de persona jurídica"  |"8604667181"        |  "EFECTIVA 1"   | "0038472733" | "Cuenta Ahorro"   |
      | "16062020"     | "1606"   | "NIT de persona jurídica"  |"8604667181"        |  "EFECTIVA 1"   | "0106528680" | "Cuenta Ahorro"   |
      | "16062020"     | "1606"   | "NIT de persona jurídica"  |"8604667181"        |  "EFECTIVA 1"   | "0076469876" | "Cuenta Ahorro"   |
      | "16062020"     | "1606"   | "NIT de persona jurídica"  |"8604667181"        |  "EFECTIVA 1"   | "0038477733" | "Cuenta Ahorro"   |
      | "16062020"     | "1606"   | "NIT de persona jurídica"  |"8604667181"        |  "EFECTIVA 1"   | "0048272733" | "Cuenta Ahorro"   |


  @Migraciones
  Scenario Outline: Realizar Migraciones a través de la opción de Unidades de negocio
    Given La empresa a modificar debe existir  y tener asociado un tipo <Tipo>  y numero <Numero>
    When  Seleccionar numero de cuenta <NumeroCuenta> y la unidad de negocio nueva <Unidad>
    Then  Mensaje informativo cambio unidad de negocio
    Then  Consultar datos con nombre de la empresa <Empresa> fechas inicial <FechaI> y fecha final <FechaF>
    Examples:
      |FechaI          |FechaF     | Empresa| Tipo                       |Numero                      |   NumeroCuenta  |Unidad|
      | "17062020"     | "1706"    | "EMPRESA PRUEBAS MARTHA"      | "Registro civil"  |"1234567890" |  "0057363822"   | "0000" |

  @MigracionesC
  Scenario Outline: Realizar Migraciones a través de la opción convenios
    Given Buscar la Empresa con  tipo <Tipo>  y numero <Numero> de identificacion
    When  Seleccionar Convenio actual <ConvenioA> y convenio nuevo <ConvenioN>
    Then  Mensaje informativo cambio convenio
    Then  Consultar dato con nombre de la empresa <Empresa> fechas inicial <FechaI> y fecha final <FechaF>
    Examples:
      |FechaI          |FechaF     | Empresa  | Tipo                      |Numero       |  ConvenioA          |ConvenioN              |
      | "17062020"     | "1706"    | "EMPRESA PRUEBAS MARTHA" | "NIT de persona jurídica"  |"8604667181" |  "419329-MasEfectivaFull"| "419329-MAS EFECTIVA 4" |

  @OtrasConfiguraciones
  Scenario Outline:Actualizar las configuraciones generales por el modulo otras configuraciones
    Given Seleccionar Empresa <Empresa> a  gestionar
    When  Seleccionar  tipo conveno <Convenio>  y el tipo dispersion <Dispersion>
    When  Seleccionar PGP <Pgp>  y Reexpedicion <Reexpedicion>
    When  Seleccianar Sede <Sede> y Custodio <Custodio>
    When  Diligenciar los siguiente campos  <Tipo_Identificacion> <Numero_Identificacion> <Nombre_Custodio> <Direccion> <Departamento> <Ciudad> <Telefono> segun custodio seleccioando
    Then  Mensaje  informativo
    Examples:
      |  Empresa                   |Convenio        |   Dispersion  | Pgp   |Reexpedicion|Sede               |Custodio                                                        |Tipo_Identificacion     |Numero_Identificacion|Nombre_Custodio |Direccion      |Departamento  |Ciudad   |Telefono    |
      | "EMPRESA PRUEBAS MARTHA"  |"ALIMENTACION 9" |  "Consolidado"| "No"  |"Si"        |"0000000001 Calle 153 #7-59"|"Funcionario (Custodio principal Tarjeta)"    |"NIT de persona natural"|"1234567890"         |"Funcionario1"  |"calle 97"     |"ARAUCA"      |"ARAUCA" |"3013633400"|



  @TrasladoSaldo
  Scenario Outline: Realizar Traslado Saldo a cuentas registro unico
    Given  validar el saldo de la tarjeta <Tarjeta> antes de realizar el  proceso
    Given  La empresa  con tipo de identificacion <Tipo> y numero <Numero> debe estar creada
    When   Seleccionar tipo de traslado <TipoTraslado>
    When   Llenar formulario de registro Unico diligenciando los siguientes campos  Motivo <Motivo> Numero cuenta <Numero> Monto <Monto>
    Then   Mensaje informativo de traslado
    Then   Consultar datos con fechas inicial <FechaI> y fecha final <FechaF> validando que el registro sea Exitoso
    Then   validar nuevamente el saldo de la tarjeta
    Examples:
      |Tarjeta |Tipo                     |Numero      |TipoTraslado|   Motivo          | Numero                      |Monto |FechaI       |FechaF   |
      |"848393"|"NIT de persona jurídica"|"8604667181"|"Unico"    |"Traslado temporal"|"0019846868-Cuenta Corriente"|"1222"|  "17062020" | "062020"|
