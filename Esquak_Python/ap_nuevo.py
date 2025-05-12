import tkinter as tk
from tkinter import ttk, messagebox
import json
import os

class SistemaClases:
    def __init__(self, root):
        self.resenas_file = "resenas.json"
        self.root = root
        self.root.title("Sistema de Clases Profesor-Alumno")
        self.root.geometry("800x600")
        
        # Datos de usuarios y clases
        self.usuarios_file = "usuarios.json"
        self.clases_file = "clases.json"
        self.reseñas_file = "reseñas.json"
        
        # Cargar datos existentes o inicializar
        self.cargar_datos()
        self.cargar_datos_reseñas()

        self.reseñas = []
        
        # Mostrar pantalla de inicio
        self.mostrar_login()

    def cargar_datos(self):
        """Cargar datos de usuarios y clases desde archivos JSON"""
        # Usuarios
        if os.path.exists(self.usuarios_file):
            with open(self.usuarios_file, 'r') as f:
                self.usuarios = json.load(f)
        else:
            self.usuarios = {"profesores": [], "alumnos": []}
        
        # Clases
        if os.path.exists(self.clases_file):
            with open(self.clases_file, 'r') as f:
                self.clases = json.load(f)
        else:
            self.clases = []

    def guardar_datos(self):
        """Guardar datos de usuarios y clases en archivos JSON"""
        with open(self.usuarios_file, 'w') as f:
            json.dump(self.usuarios, f)
        
        with open(self.clases_file, 'w') as f:
            json.dump(self.clases, f)

    def cargar_datos_reseñas(self):
        """Cargar reseñas desde archivo"""
        if os.path.exists(self.reseñas_file):
            with open(self.reseñas_file, "r", encoding="utf-8") as f:
                self.reseñas = json.load(f)
        else:
            self.reseñas = []

    def guardar_datos_reseñas(self):
        """Guardar reseñas en archivo"""
        with open(self.reseñas_file, "w", encoding="utf-8") as f:
            json.dump(self.reseñas, f, indent=2, ensure_ascii=False)


    def mostrar_login(self):
        """Mostrar pantalla de inicio de sesión"""
        self.limpiar_pantalla()
        
        # Frame principal
        frame = ttk.Frame(self.root, padding="30")
        frame.pack(expand=True)
        
        # Título
        ttk.Label(frame, text="Inicio de Sesión", font=("Helvetica", 16)).grid(row=0, column=0, columnspan=2, pady=10)
        
        # Campos de entrada
        ttk.Label(frame, text="Usuario:").grid(row=1, column=0, sticky="e", pady=5)
        self.usuario_entry = ttk.Entry(frame)
        self.usuario_entry.grid(row=1, column=1, pady=5)
        
        ttk.Label(frame, text="Contraseña:").grid(row=2, column=0, sticky="e", pady=5)
        self.password_entry = ttk.Entry(frame, show="*")
        self.password_entry.grid(row=2, column=1, pady=5)
        
        # Tipo de usuario
        ttk.Label(frame, text="Tipo de usuario:").grid(row=3, column=0, sticky="e", pady=5)
        self.tipo_usuario = tk.StringVar()
        ttk.Radiobutton(frame, text="Alumno", variable=self.tipo_usuario, value="alumno").grid(row=3, column=1, sticky="w")
        ttk.Radiobutton(frame, text="Profesor", variable=self.tipo_usuario, value="profesor").grid(row=4, column=1, sticky="w")
        self.tipo_usuario.set("alumno")
        
        # Botones
        ttk.Button(frame, text="Iniciar Sesión", command=self.iniciar_sesion).grid(row=5, column=0, columnspan=2, pady=10)
        ttk.Button(frame, text="Registrarse", command=self.mostrar_registro).grid(row=6, column=0, columnspan=2, pady=5)

    def mostrar_registro(self):
        """Mostrar pantalla de registro"""
        self.limpiar_pantalla()
        
        # Frame principal
        frame = ttk.Frame(self.root, padding="30")
        frame.pack(expand=True)
        
        # Título
        ttk.Label(frame, text="Registro de Usuario", font=("Helvetica", 16)).grid(row=0, column=0, columnspan=2, pady=10)
        
        # Campos de entrada
        ttk.Label(frame, text="Nombre completo:").grid(row=1, column=0, sticky="e", pady=5)
        self.reg_nombre_entry = ttk.Entry(frame)
        self.reg_nombre_entry.grid(row=1, column=1, pady=5)
        
        ttk.Label(frame, text="Correo electrónico:").grid(row=2, column=0, sticky="e", pady=5)
        self.reg_email_entry = ttk.Entry(frame)
        self.reg_email_entry.grid(row=2, column=1, pady=5)
        
        ttk.Label(frame, text="Usuario:").grid(row=3, column=0, sticky="e", pady=5)
        self.reg_usuario_entry = ttk.Entry(frame)
        self.reg_usuario_entry.grid(row=3, column=1, pady=5)
        
        ttk.Label(frame, text="Contraseña:").grid(row=4, column=0, sticky="e", pady=5)
        self.reg_password_entry = ttk.Entry(frame, show="*")
        self.reg_password_entry.grid(row=4, column=1, pady=5)
        
        ttk.Label(frame, text="Confirmar contraseña:").grid(row=5, column=0, sticky="e", pady=5)
        self.reg_confirm_password_entry = ttk.Entry(frame, show="*")
        self.reg_confirm_password_entry.grid(row=5, column=1, pady=5)
        
        # Tipo de usuario
        ttk.Label(frame, text="Tipo de usuario:").grid(row=6, column=0, sticky="e", pady=5)
        self.reg_tipo_usuario = tk.StringVar()
        ttk.Radiobutton(frame, text="Alumno", variable=self.reg_tipo_usuario, value="alumno").grid(row=6, column=1, sticky="w")
        ttk.Radiobutton(frame, text="Profesor", variable=self.reg_tipo_usuario, value="profesor").grid(row=7, column=1, sticky="w")
        self.reg_tipo_usuario.set("alumno")
        
        # Campos adicionales para profesores
        ttk.Label(frame, text="Especialidad (profesores):").grid(row=8, column=0, sticky="e", pady=5)
        self.reg_especialidad_entry = ttk.Entry(frame)
        self.reg_especialidad_entry.grid(row=8, column=1, pady=5)
        
        # Botones
        ttk.Button(frame, text="Registrarse", command=self.registrar_usuario).grid(row=9, column=0, columnspan=2, pady=10)
        ttk.Button(frame, text="Volver al inicio", command=self.mostrar_login).grid(row=10, column=0, columnspan=2, pady=5)

    def iniciar_sesion(self):
        """Validar credenciales e iniciar sesión"""
        usuario = self.usuario_entry.get()
        password = self.password_entry.get()
        tipo = self.tipo_usuario.get()
        
        if not usuario or not password:
            messagebox.showerror("Error", "Por favor complete todos los campos")
            return
        
        # Buscar usuario
        usuarios = self.usuarios["profesores"] if tipo == "profesor" else self.usuarios["alumnos"]
        encontrado = False
        
        for u in usuarios:
            if u["usuario"] == usuario and u["password"] == password:
                encontrado = True
                self.usuario_actual = u
                self.tipo_usuario_actual = tipo
                break
        
        if encontrado:
            if tipo == "profesor":
                self.mostrar_pantalla_profesor()
            else:
                self.mostrar_pantalla_alumno()
        else:
            messagebox.showerror("Error", "Usuario o contraseña incorrectos")

    def registrar_usuario(self):
        """Registrar un nuevo usuario"""
        nombre = self.reg_nombre_entry.get()
        email = self.reg_email_entry.get()
        usuario = self.reg_usuario_entry.get()
        password = self.reg_password_entry.get()
        confirm_password = self.reg_confirm_password_entry.get()
        tipo = self.reg_tipo_usuario.get()
        especialidad = self.reg_especialidad_entry.get() if tipo == "profesor" else ""
        
        # Validaciones
        if not all([nombre, email, usuario, password, confirm_password]):
            messagebox.showerror("Error", "Por favor complete todos los campos")
            return
            
        if password != confirm_password:
            messagebox.showerror("Error", "Las contraseñas no coinciden")
            return
            
        # Verificar si el usuario ya existe
        usuarios = self.usuarios["profesores"] + self.usuarios["alumnos"]
        for u in usuarios:
            if u["usuario"] == usuario:
                messagebox.showerror("Error", "El nombre de usuario ya está en uso")
                return
            if u["email"] == email:
                messagebox.showerror("Error", "El correo electrónico ya está registrado")
                return
        
        # Crear nuevo usuario
        nuevo_usuario = {
            "nombre": nombre,
            "email": email,
            "usuario": usuario,
            "password": password,
            "especialidad": especialidad if tipo == "profesor" else ""
        }
        
        if tipo == "profesor":
            self.usuarios["profesores"].append(nuevo_usuario)
        else:
            self.usuarios["alumnos"].append(nuevo_usuario)
        
        self.guardar_datos()
        messagebox.showinfo("Éxito", "Usuario registrado correctamente")
        self.mostrar_login()

    def mostrar_pantalla_profesor(self):
        """Mostrar pantalla principal para profesores"""
        self.limpiar_pantalla()
        
        # Frame principal
        frame = ttk.Frame(self.root, padding="20")
        frame.pack(expand=True, fill="both")
        
        # Bienvenida
        ttk.Label(frame, 
                 text=f"Bienvenido, Profesor {self.usuario_actual['nombre']}",
                 font=("Helvetica", 14)).pack(pady=10)
        
        # Pestañas
        notebook = ttk.Notebook(frame)
        notebook.pack(expand=True, fill="both", pady=10)
        
        # Pestaña 1: Publicar nueva clase
        tab1 = ttk.Frame(notebook)
        notebook.add(tab1, text="Publicar Clase")
        
        ttk.Label(tab1, text="Título de la clase:").grid(row=0, column=0, sticky="e", pady=5)
        self.clase_titulo_entry = ttk.Entry(tab1, width=40)
        self.clase_titulo_entry.grid(row=0, column=1, pady=5, padx=5)
        
        ttk.Label(tab1, text="Descripción:").grid(row=1, column=0, sticky="ne", pady=5)
        self.clase_descripcion_text = tk.Text(tab1, width=40, height=5)
        self.clase_descripcion_text.grid(row=1, column=1, pady=5, padx=5)
        
        ttk.Label(tab1, text="Precio ($):").grid(row=2, column=0, sticky="e", pady=5)
        self.clase_precio_entry = ttk.Entry(tab1)
        self.clase_precio_entry.grid(row=2, column=1, pady=5, padx=5, sticky="w")
        
        ttk.Label(tab1, text="Duración (minutos):").grid(row=3, column=0, sticky="e", pady=5)
        self.clase_duracion_entry = ttk.Entry(tab1)
        self.clase_duracion_entry.grid(row=3, column=1, pady=5, padx=5, sticky="w")
        
        ttk.Button(tab1, text="Publicar Clase", command=self.publicar_clase).grid(row=4, column=1, pady=10, sticky="e")
        
        # Pestaña 2: Mis clases publicadas
        tab2 = ttk.Frame(notebook)
        notebook.add(tab2, text="Mis Clases")
        
        # Treeview para mostrar clases
        columns = ("id", "titulo", "precio", "duracion", "descripcion")
        self.tree_profesor = ttk.Treeview(tab2, columns=columns, show="headings", height=10)
        
        self.tree_profesor.heading("id", text="ID")
        self.tree_profesor.heading("titulo", text="Título")
        self.tree_profesor.heading("precio", text="Precio")
        self.tree_profesor.heading("duracion", text="Duración")
        self.tree_profesor.heading("descripcion", text="Descripción")
        
        self.tree_profesor.column("id", width=50, anchor="center")
        self.tree_profesor.column("titulo", width=150)
        self.tree_profesor.column("precio", width=80, anchor="center")
        self.tree_profesor.column("duracion", width=80, anchor="center")
        self.tree_profesor.column("descripcion", width=250)
        
        self.tree_profesor.pack(expand=True, fill="both", padx=5, pady=5)
        
        # Botón para eliminar clase
        ttk.Button(tab2, text="Eliminar Clase Seleccionada", 
                  command=self.eliminar_clase_profesor).pack(pady=5)
        
        # Cargar clases del profesor
        self.cargar_clases_profesor()

        ttk.Button(frame, text="Ver Reseñas Recibidas", command=self.mostrar_reseñas_profesor).pack(pady=5)
        
        # Botón de cerrar sesión
        ttk.Button(frame, text="Cerrar Sesión", command=self.mostrar_login).pack(pady=10)

    def mostrar_pantalla_alumno(self):
        """Mostrar pantalla principal para alumnos"""
        self.limpiar_pantalla()
        
        # Frame principal
        frame = ttk.Frame(self.root, padding="20")
        frame.pack(expand=True, fill="both")
        
        # Bienvenida
        ttk.Label(frame, 
                 text=f"Bienvenido, {self.usuario_actual['nombre']}",
                 font=("Helvetica", 14)).pack(pady=10)
        
        # Pestañas
        notebook = ttk.Notebook(frame)
        notebook.pack(expand=True, fill="both", pady=10)
        
        # Pestaña 1: Buscar clases
        tab1 = ttk.Frame(notebook)
        notebook.add(tab1, text="Buscar Clases")
        
        # Filtros de búsqueda
        ttk.Label(tab1, text="Buscar:").grid(row=0, column=0, sticky="e", pady=5)
        self.busqueda_entry = ttk.Entry(tab1, width=40)
        self.busqueda_entry.grid(row=0, column=1, pady=5, padx=5)
        
        ttk.Label(tab1, text="Filtrar por profesor:").grid(row=1, column=0, sticky="e", pady=5)
        self.filtro_profesor = ttk.Combobox(tab1, values=self.obtener_profesores())
        self.filtro_profesor.grid(row=1, column=1, pady=5, padx=5, sticky="w")
        self.filtro_profesor.set("Todos")
        
        ttk.Button(tab1, text="Buscar", command=self.buscar_clases).grid(row=2, column=1, pady=5, sticky="e")
        
        # Resultados de búsqueda
        columns = ("id", "titulo", "profesor", "precio", "duracion")
        self.tree_alumno = ttk.Treeview(tab1, columns=columns, show="headings", height=10)
        
        self.tree_alumno.heading("id", text="ID")
        self.tree_alumno.heading("titulo", text="Título")
        self.tree_alumno.heading("profesor", text="Profesor")
        self.tree_alumno.heading("precio", text="Precio")
        self.tree_alumno.heading("duracion", text="Duración")
        
        self.tree_alumno.column("id", width=50, anchor="center")
        self.tree_alumno.column("titulo", width=150)
        self.tree_alumno.column("profesor", width=150)
        self.tree_alumno.column("precio", width=80, anchor="center")
        self.tree_alumno.column("duracion", width=80, anchor="center")
        
        self.tree_alumno.grid(row=3, column=0, columnspan=2, pady=10, padx=5, sticky="nsew")
        
        # Botón para comprar clase
        ttk.Button(tab1, text="Comprar Clase Seleccionada", 
                  command=self.comprar_clase).grid(row=4, column=0, columnspan=2, pady=5)
        
        # Configurar expansión
        tab1.grid_rowconfigure(3, weight=1)
        tab1.grid_columnconfigure(1, weight=1)
        
        # Pestaña 2: Mis clases compradas
        tab2 = ttk.Frame(notebook)
        notebook.add(tab2, text="Mis Clases")
        
        # Treeview para mostrar clases compradas
        columns = ("id", "titulo", "profesor", "precio", "fecha")
        self.tree_mis_clases = ttk.Treeview(tab2, columns=columns, show="headings", height=10)
        
        self.tree_mis_clases.heading("id", text="ID")
        self.tree_mis_clases.heading("titulo", text="Título")
        self.tree_mis_clases.heading("profesor", text="Profesor")
        self.tree_mis_clases.heading("precio", text="Precio")
        self.tree_mis_clases.heading("fecha", text="Fecha Compra")
        
        self.tree_mis_clases.pack(expand=True, fill="both", padx=5, pady=5)
        
        # Cargar clases compradas (en un sistema real aquí se conectaría con una BD de compras)
        # En este ejemplo simplificado, no implementamos el sistema de compras completo
        
        # Botón de cerrar sesión
        ttk.Button(frame, text="Cerrar Sesión", command=self.mostrar_login).pack(pady=10)

        ttk.Button(frame, text="Ver / Escribir Reseñas", command=self.mostrar_reseñas_alumno).pack(pady=5)

        
        # Cargar todas las clases al inicio
        self.buscar_clases()

    def publicar_clase(self):
        """Publicar una nueva clase"""
        titulo = self.clase_titulo_entry.get()
        descripcion = self.clase_descripcion_text.get("1.0", "end-1c")
        precio = self.clase_precio_entry.get()
        duracion = self.clase_duracion_entry.get()
        
        if not all([titulo, descripcion, precio, duracion]):
            messagebox.showerror("Error", "Por favor complete todos los campos")
            return
            
        try:
            precio = float(precio)
            duracion = int(duracion)
        except ValueError:
            messagebox.showerror("Error", "Precio debe ser un número y duración un entero")
            return
        
        # Crear nueva clase
        nueva_clase = {
            "id": len(self.clases) + 1,
            "titulo": titulo,
            "descripcion": descripcion,
            "precio": precio,
            "duracion": duracion,
            "profesor": self.usuario_actual["usuario"],
            "profesor_nombre": self.usuario_actual["nombre"]
        }
        
        self.clases.append(nueva_clase)
        self.guardar_datos()
        
        messagebox.showinfo("Éxito", "Clase publicada correctamente")
        self.clase_titulo_entry.delete(0, "end")
        self.clase_descripcion_text.delete("1.0", "end")
        self.clase_precio_entry.delete(0, "end")
        self.clase_duracion_entry.delete(0, "end")
        
        # Actualizar lista de clases
        self.cargar_clases_profesor()

    def cargar_clases_profesor(self):
        """Cargar las clases del profesor actual en el Treeview"""
        # Limpiar treeview
        for item in self.tree_profesor.get_children():
            self.tree_profesor.delete(item)
        
        # Filtrar clases del profesor actual
        clases_profesor = [c for c in self.clases if c["profesor"] == self.usuario_actual["usuario"]]
        
        # Agregar clases al treeview
        for clase in clases_profesor:
            self.tree_profesor.insert("", "end", 
                                    values=(clase["id"], clase["titulo"], f"${clase['precio']}", 
                                            f"{clase['duracion']} min", clase["descripcion"]))

    def eliminar_clase_profesor(self):
        """Eliminar la clase seleccionada por el profesor"""
        seleccion = self.tree_profesor.selection()
        if not seleccion:
            messagebox.showerror("Error", "Por favor seleccione una clase")
            return
            
        item = self.tree_profesor.item(seleccion[0])
        id_clase = item["values"][0]
        
        # Confirmar eliminación
        if not messagebox.askyesno("Confirmar", "¿Está seguro de eliminar esta clase?"):
            return
        
        # Eliminar clase
        self.clases = [c for c in self.clases if c["id"] != id_clase]
        self.guardar_datos()
        
        messagebox.showinfo("Éxito", "Clase eliminada correctamente")
        self.cargar_clases_profesor()

    def obtener_profesores(self):
        """Obtener lista de nombres de profesores para el filtro"""
        profesores = ["Todos"] + [p["nombre"] for p in self.usuarios["profesores"]]
        return profesores

    def buscar_clases(self):
        """Buscar clases según los filtros"""
        texto_busqueda = self.busqueda_entry.get().lower()
        profesor_filtro = self.filtro_profesor.get()
        
        # Limpiar treeview
        for item in self.tree_alumno.get_children():
            self.tree_alumno.delete(item)
        
        # Filtrar clases
        clases_filtradas = []
        for clase in self.clases:
            # Filtrar por texto de búsqueda
            if (texto_busqueda in clase["titulo"].lower() or 
                texto_busqueda in clase["descripcion"].lower() or
                texto_busqueda in clase["profesor_nombre"].lower() or
                not texto_busqueda):
                
                # Filtrar por profesor
                if profesor_filtro == "Todos" or profesor_filtro == clase["profesor_nombre"]:
                    clases_filtradas.append(clase)
        
        # Mostrar resultados
        for clase in clases_filtradas:
            self.tree_alumno.insert("", "end", 
                                  values=(clase["id"], clase["titulo"], clase["profesor_nombre"], 
                                          f"${clase['precio']}", f"{clase['duracion']} min"))

    def comprar_clase(self):
        """Proceso de compra de una clase (simulado)"""
        seleccion = self.tree_alumno.selection()
        if not seleccion:
            messagebox.showerror("Error", "Por favor seleccione una clase")
            return
            
        item = self.tree_alumno.item(seleccion[0])
        id_clase = item["values"][0]
        titulo_clase = item["values"][1]
        
        # En un sistema real aquí se procesaría el pago
        # En este ejemplo solo mostramos un mensaje
        messagebox.showinfo("Compra exitosa", 
                          f"Has comprado la clase '{titulo_clase}'\nID: {id_clase}\n\nEn un sistema real, aquí se completaría el proceso de pago.")
        
    def mostrar_reseñas_alumno(self):
        self.limpiar_pantalla()
        frame = ttk.Frame(self.root, padding="20")
        frame.pack()

        ttk.Label(frame, text="Reseñas de Profesores", font=("Arial", 14)).pack(pady=10)

    # Mostrar reseñas existentes
        for reseña in self.reseñas:
            ttk.Label(frame, text=f"Profesor: {reseña['profesor']}").pack()
            ttk.Label(frame, text=f"Reseña: {reseña['texto']}").pack(pady=5)

        ttk.Label(frame, text="Escribir nueva reseña", font=("Arial", 12)).pack(pady=10)

        ttk.Label(frame, text="Profesor:").pack()
        profesor_entry = ttk.Entry(frame)
        profesor_entry.pack()

        ttk.Label(frame, text="Reseña:").pack()
        texto_entry = ttk.Entry(frame, width=50)
        texto_entry.pack()

        def guardar():
            profesor = profesor_entry.get()
            texto = texto_entry.get()
            if not profesor or not texto:
                messagebox.showerror("Error", "Completa ambos campos")
                return
            if not any(p["nombre"] == profesor for p in self.usuarios["profesores"]):
                messagebox.showerror("Error", "Ese profesor no existe")
                return
            self.reseñas.append({"profesor": profesor, "texto": texto})
            self.guardar_datos_reseñas()
            messagebox.showinfo("Éxito", "Reseña guardada correctamente")
            self.mostrar_reseñas_alumno()

    # Botones (fuera del guardar)
        ttk.Button(frame, text="Guardar Reseña", command=guardar).pack(pady=5)
        ttk.Button(frame, text="Volver", command=self.mostrar_pantalla_alumno).pack(pady=5)
   


    def mostrar_reseñas_profesor(self):
        self.limpiar_pantalla()
        frame = ttk.Frame(self.root, padding="20")
        frame.pack()
        ttk.Label(frame, text=f"Reseñas para {self.usuario_actual['nombre']}", font=("Arial", 14)).pack(pady=10)
        encontradas = False
        for reseña in self.reseñas:
            if reseña["profesor"] == self.usuario_actual["nombre"]:
                ttk.Label(frame, text=f"- {reseña['texto']}").pack(anchor="w", padx=10, pady=2)
                encontradas = True
                if not encontradas:
                    ttk.Label(frame, text="Aún no has recibido reseñas.").pack(pady=10)
                    ttk.Button(frame, text="Volver", command=self.mostrar_pantalla_profesor).pack(pady=10)

    def limpiar_pantalla(self):
        """Limpiar todos los widgets de la pantalla"""
        for widget in self.root.winfo_children():
            widget.destroy()

if __name__ == "__main__":
    root = tk.Tk()
    app = SistemaClases(root)
    root.mainloop()