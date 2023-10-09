create database S1_N1
go
use S1_N1
go

create table ChucVu(
	MaCV nvarchar(10) not null,
	TenCV nvarchar(50) not null,
	primary key (MaCV)
)
create table Ca(
	MaCa nvarchar(10) not null,
	TenCa nvarchar(50) not null,
	TrangThai bit,
	primary key (MaCa)
)
create table NhanVien(
	MaNV nvarchar(10) not null,
	HoTen nvarchar(50) not null,
	SDT nvarchar(12),
	Diachi nvarchar(30),
	GioiTinh bit not null,
	NgaySinh date,
	MatKhau nvarchar(10) not null,
	MaCV nvarchar(10) not null,
	Luong float not null,
	MaCa nvarchar(10) not null,
	TrangThai bit,
	primary key (MaNV),
	foreign key (MaCV) references ChucVu(MaCV),
	foreign key (MaCa) references Ca(MaCa)
)
create table KhachHang(
	MaKH nvarchar(10) not null,
	HoTen nvarchar(50) not null,
	SDT nvarchar(12),
	DiaChi nvarchar(30),
	GioiTinh bit not null,
	NgaySinh date,
	TrangThai bit,
	primary key (MaKH)
)
create table HoaDon(
	MaHD nvarchar(10) not null,
	NgayTao date,
	MaNV nvarchar(10) not null,
	MaKH nvarchar(10) not null,
	TrangThai bit,
	primary key (MaHD),
	foreign key (MaNV) references NhanVien(MaNV),
	foreign key (MaKH) references KhachHang(MaKH)
)
create table SanPham(
	MaSP nvarchar(10) not null,
	TenSP nvarchar(30) not null,
	NgayNhap date,
	TrangThai bit,
	primary key (MaSP)
)
create table Size(
	MaSize nvarchar(10) not null,
	Size nvarchar(5) not null,
	TrangThai bit,
	primary key (MaSize)
)
create table KhuyenMai(
	MaKM nvarchar(10) not null,
	TenKM nvarchar(50) not null,
	LoaiKM nvarchar(30) not null,
	NgayBD date,
	NgayKT date,
	TrangThai bit,
	primary key (MaKM)
)
create table MauSac(
	MaMS nvarchar(10) not null,
	TenMS nvarchar(50) not null,
	TrangThai bit,
	primary key (MaMS)
)
create table NSX(
	MaNSX nvarchar(10) not null,
	TenNSX nvarchar(50) not null,
	DiaChi nvarchar(30),
	TrangThai bit,
	primary key (MaNSX)
)
create table TheLoai(
	MaTL nvarchar(10) not null,
	TenTL nvarchar(50) not null,
	TrangThai bit,
	primary key (MaTL)
)

CREATE TABLE HoaDonCT(
    MaHD nvarchar(10) not null,
    MaKM nvarchar(10) not null,
    MaSP nvarchar(10) not null,
    Gia float not null,
    SoLuong int not null,
    TienKhachDua float not null,
    TienThua float not null,
    TrangThai bit,
    PRIMARY KEY (MaHD, MaKM, MaSP),
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    FOREIGN KEY (MaKM) REFERENCES KhuyenMai(MaKM),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
)
create table SanPhamCT(
	MaSP nvarchar(10) not null,
	MaMS nvarchar(10) not null,
	MaNSX nvarchar(10) not null,
	MaSize nvarchar(10) not null,
	MaTL nvarchar(10) not null,
	Gia float not null,
	SoLuong int not null,
	TrangThai bit,
	primary key (MaSP, MaMS, MaNSX, MaSize, MaTL),
	foreign key (MaSP) references SanPham(MaSP),
	foreign key (MaMS) references MauSac(MaMS),
	foreign key (MaNSX) references NSX(MaNSX),
	foreign key (MaSize) references Size(MaSize),
	foreign key (MaTL) references TheLoai(MaTL)
)

select*from SanPhamCT
insert into TheLoai
values ('M2',N'Quần dài',1)