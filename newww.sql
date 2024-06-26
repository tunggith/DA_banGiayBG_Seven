USE [master]
GO
/****** Object:  Database [DA_banGiay_BG_Seven]    Script Date: 12/12/2023 1:09:19 PM ******/
CREATE DATABASE [DA_banGiay_BG_Seven]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DA_banGiay_BG_Seven', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DA_banGiay_BG_Seven.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DA_banGiay_BG_Seven_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\DA_banGiay_BG_Seven_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DA_banGiay_BG_Seven].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET ARITHABORT OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET RECOVERY FULL 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET  MULTI_USER 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET QUERY_STORE = OFF
GO
USE [DA_banGiay_BG_Seven]
GO
/****** Object:  Table [dbo].[chatLieu]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chatLieu](
	[id_chatLieu] [int] IDENTITY(1,1) NOT NULL,
	[tenChatLieu] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_chatLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoaDon]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDon](
	[id_hoaDon] [int] IDENTITY(1,1) NOT NULL,
	[id_nhanVien] [int] NOT NULL,
	[trangThai] [bit] NOT NULL,
	[ngayTao] [date] NOT NULL,
	[id_khachHang] [int] NULL,
	[id_khuyenMai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_hoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[hoaDonCT]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[hoaDonCT](
	[id_hoaDonCt] [int] IDENTITY(1,1) NOT NULL,
	[id_hoaDon] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[donGia] [float] NOT NULL,
	[id_sanPhamCt] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_hoaDonCt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khachHang]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khachHang](
	[id_khachHang] [int] IDENTITY(1,1) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[diaChi] [nvarchar](100) NOT NULL,
	[soDienThoai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_khachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[khuyenMai]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[khuyenMai](
	[id_khuyenMai] [int] IDENTITY(1,1) NOT NULL,
	[tenKhuyenMai] [nvarchar](50) NOT NULL,
	[loai] [nvarchar](100) NOT NULL,
	[giaTri] [nvarchar](20) NOT NULL,
	[ngayBatDau] [date] NOT NULL,
	[ngayKetThuc] [date] NOT NULL,
	[trangThai] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_khuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[mau]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[mau](
	[id_mau] [int] IDENTITY(1,1) NOT NULL,
	[tenMau] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_mau] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhaCungCap]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhaCungCap](
	[id_nhaCungCap] [int] IDENTITY(1,1) NOT NULL,
	[tenNhaCungCap] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_nhaCungCap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[nhanVien]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[nhanVien](
	[id_nhanVien] [int] IDENTITY(1,1) NOT NULL,
	[hoTen] [nvarchar](50) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[soDt] [int] NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](200) NOT NULL,
	[id_taiKhoan] [int] NOT NULL,
	[trangThai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id_nhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sanPham]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sanPham](
	[id_sanPham] [int] IDENTITY(1,1) NOT NULL,
	[tenSanPham] [nvarchar](100) NOT NULL,
	[ghiChu] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_sanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[sanPhamCt]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[sanPhamCt](
	[id_sanPhamCt] [int] IDENTITY(1,1) NOT NULL,
	[id_sanPham] [int] NOT NULL,
	[id_theLoai] [int] NOT NULL,
	[id_chatLieu] [int] NOT NULL,
	[id_thuongHieu] [int] NOT NULL,
	[id_nhaCungCap] [int] NOT NULL,
	[id_mau] [int] NOT NULL,
	[gia] [float] NOT NULL,
	[size] [int] NOT NULL,
	[soLuong] [int] NOT NULL,
	[ghiChu] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[id_sanPhamCt] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[taiKhoan]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[taiKhoan](
	[id_taiKHoan] [int] IDENTITY(1,1) NOT NULL,
	[tenDangNhap] [nvarchar](50) NOT NULL,
	[matKhau] [varchar](20) NOT NULL,
	[vaiTro] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_taiKHoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[theloai]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[theloai](
	[id_theLoai] [int] IDENTITY(1,1) NOT NULL,
	[tenTheLoai] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_theLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[thuongHieu]    Script Date: 12/12/2023 1:09:19 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[thuongHieu](
	[id_thuongHieu] [int] IDENTITY(1,1) NOT NULL,
	[tenThuongHieu] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id_thuongHieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[chatLieu] ON 

INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu]) VALUES (1, N'vải')
INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu]) VALUES (2, N'da bò')
INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu]) VALUES (3, N'cacbon')
INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu]) VALUES (4, N'lụa')
INSERT [dbo].[chatLieu] ([id_chatLieu], [tenChatLieu]) VALUES (5, N'ninonn')
SET IDENTITY_INSERT [dbo].[chatLieu] OFF
GO
SET IDENTITY_INSERT [dbo].[hoaDon] ON 

INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (2, 5, 1, CAST(N'2023-10-11' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (3, 1, 1, CAST(N'2023-09-02' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (4, 2, 1, CAST(N'2023-01-11' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (5, 4, 1, CAST(N'2023-06-28' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (6, 2, 1, CAST(N'2023-12-10' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (7, 1, 1, CAST(N'2023-12-09' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (8, 1, 1, CAST(N'2023-11-11' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (10, 2, 1, CAST(N'2023-12-09' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (11, 2, 1, CAST(N'2023-12-09' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (12, 2, 1, CAST(N'2023-12-09' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (13, 3, 1, CAST(N'2023-12-09' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (14, 3, 1, CAST(N'2023-12-09' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (15, 4, 1, CAST(N'2023-12-09' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (16, 4, 1, CAST(N'2023-12-09' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (17, 4, 1, CAST(N'2023-12-09' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (18, 4, 1, CAST(N'2023-12-09' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (19, 4, 1, CAST(N'2023-12-09' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (21, 2, 1, CAST(N'2023-12-09' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (22, 2, 1, CAST(N'2023-12-09' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (23, 2, 1, CAST(N'2023-12-09' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (24, 1, 1, CAST(N'2023-12-09' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (25, 7, 1, CAST(N'2023-12-09' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (26, 1, 1, CAST(N'2023-12-09' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (27, 7, 1, CAST(N'2023-12-09' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (28, 1, 1, CAST(N'2023-12-09' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (29, 7, 1, CAST(N'2023-12-09' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (30, 1, 1, CAST(N'2023-12-09' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (31, 7, 1, CAST(N'2023-12-09' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (32, 1, 1, CAST(N'2023-12-09' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (33, 7, 1, CAST(N'2023-12-09' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (34, 2, 1, CAST(N'2023-12-09' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1009, 2, 1, CAST(N'2023-12-09' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1010, 1, 1, CAST(N'2023-12-09' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1011, 7, 1, CAST(N'2023-12-09' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1012, 1, 1, CAST(N'2023-12-09' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1013, 7, 1, CAST(N'2023-12-09' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1014, 1, 1, CAST(N'2023-12-09' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1015, 7, 1, CAST(N'2023-12-09' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1016, 2, 1, CAST(N'2023-12-09' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1017, 2, 1, CAST(N'2023-12-09' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1018, 2, 1, CAST(N'2023-11-30' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1019, 2, 1, CAST(N'2023-11-30' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1020, 1, 1, CAST(N'2023-11-30' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1021, 7, 1, CAST(N'2023-11-30' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1022, 1, 1, CAST(N'2023-11-30' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1023, 7, 1, CAST(N'2023-11-30' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1024, 1, 1, CAST(N'2023-11-30' AS Date), 9, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1025, 7, 1, CAST(N'2023-11-30' AS Date), 9, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1026, 1, 1, CAST(N'2023-11-30' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1027, 7, 1, CAST(N'2023-11-30' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1028, 2, 1, CAST(N'2023-12-05' AS Date), 7, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1029, 2, 1, CAST(N'2023-12-05' AS Date), 8, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1030, 2, 1, CAST(N'2023-12-05' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1031, 2, 1, CAST(N'2023-12-05' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1032, 2, 1, CAST(N'2023-12-05' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1033, 3, 1, CAST(N'2023-12-05' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1034, 1, 1, CAST(N'2023-12-05' AS Date), 5, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1035, 1, 1, CAST(N'2023-12-05' AS Date), 7, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1036, 1, 1, CAST(N'2023-12-05' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1037, 1, 1, CAST(N'2023-12-05' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1039, 1, 1, CAST(N'2023-06-12' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1040, 1, 1, CAST(N'2023-12-06' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1041, 1, 1, CAST(N'2023-12-06' AS Date), 4, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1042, 1, 1, CAST(N'2023-12-06' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1043, 5, 1, CAST(N'2023-12-07' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1044, 5, 1, CAST(N'2023-12-07' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1045, 1, 1, CAST(N'2023-12-07' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1046, 1, 1, CAST(N'2023-12-07' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1047, 1, 1, CAST(N'2023-12-07' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1048, 1, 1, CAST(N'2023-12-07' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1049, 1, 1, CAST(N'2023-12-07' AS Date), 1, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1050, 1, 1, CAST(N'2023-12-07' AS Date), 3, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1051, 1, 1, CAST(N'2023-12-10' AS Date), 2, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1052, 1, 1, CAST(N'2023-12-11' AS Date), 9, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1053, 1, 1, CAST(N'2023-12-11' AS Date), 10, 1)
INSERT [dbo].[hoaDon] ([id_hoaDon], [id_nhanVien], [trangThai], [ngayTao], [id_khachHang], [id_khuyenMai]) VALUES (1054, 1, 1, CAST(N'2023-12-12' AS Date), 2, 1)
SET IDENTITY_INSERT [dbo].[hoaDon] OFF
GO
SET IDENTITY_INSERT [dbo].[hoaDonCT] ON 

INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (2, 3, 1, 299900, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (3, 2, 1, 10000, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (4, 5, 1, 18900, 5)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (5, 4, 5, 15000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (7, 3, 1, 299900, 9)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (8, 3, 1, 299900, 20)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (9, 3, 1, 299900, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (11, 12, 1, 19999, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (13, 12, 1, 3, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (14, 11, 1, 3, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (15, 12, 1, 1, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (16, 8, 1, 1, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (17, 8, 1, 1, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (18, 8, 1, 2, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (19, 8, 2, 1, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (20, 12, 0, 10000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (21, 8, 2, 10000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (22, 11, 2, 10000, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (23, 12, 2, 10000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (24, 2, 2, 2500, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (26, 12, 1, 222, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (27, 5, 2, 299900, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (28, 12, 1, 209900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (29, 12, 2, 11, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (30, 8, 1, 299900, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (31, 2, 1, 299900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (32, 5, 1, 299900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (33, 5, 1, 299900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (34, 12, 2, 299900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (35, 12, 1, 299900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (36, 12, 1, 299900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (37, 13, 1, 12233, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (38, 13, 2, 299900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (39, 13, 1, 209900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (40, 8, 1, 12233, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (41, 13, 1, 12233, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (42, 2, 1, 299900, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (43, 2, 1, 11, 26)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (44, 14, 2, 299900, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (45, 15, 2, 190000, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (46, 2, 1, 10000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (47, 2, 1, 209900, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (48, 2, 1, 11, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (49, 17, 1, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (51, 10, 1, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (52, 11, 1, 299900, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (53, 11, 1, 299900, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (54, 11, 1, 299900, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (58, 12, 1, 299900, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (59, 12, 1, 299900, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (60, 12, 1, 299900, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (62, 10, 1, 299900, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (63, 10, 1, 299900, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (64, 10, 1, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (71, 16, 10, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (72, 18, 100, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (74, 19, 10, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (76, 22, 10, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (78, 25, 2, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (99, 24, 1, 299900, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (100, 24, 1, 299900, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (101, 24, 1, 299900, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (102, 26, 12, 15000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (103, 24, 1, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (104, 24, 2, 15000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (105, 21, 2, 15000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (106, 21, 2, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (107, 10, 1, 10000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (108, 10, 1, 10000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (113, 10, 2, 15000, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (114, 10, 1, 15000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (119, 7, 2, 15000, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (120, 7, 2, 15000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (121, 7, 1, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (122, 31, 2, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (123, 31, 1, 2500, 23)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (124, 21, 2, 15000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (125, 21, 2, 15000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1011, 5, 1, 2500, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1012, 6, 1, 15000, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1013, 7, 1, 2500, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1014, 10, 1, 2500, 1023)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1015, 23, 1, 15000, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1016, 24, 1, 15000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1017, 26, 1, 2500, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1018, 27, 1, 15000, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1019, 28, 1, 15000, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1020, 29, 1, 2500, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1021, 30, 1, 2500, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1022, 33, 1, 10000, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1023, 33, 1, 10000, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1024, 33, 1, 10000, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1025, 33, 1, 10000, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1026, 31, 1, 15000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1027, 32, 1, 2500, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1028, 1009, 2, 15000, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1029, 1009, 1, 10000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1030, 1009, 1, 10000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1031, 1009, 1, 10000, 25)
GO
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1032, 1009, 1, 10000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1033, 1009, 2, 2500, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1038, 1011, 2, 15000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1039, 34, 1, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1040, 1010, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1041, 1010, 1, 10000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1042, 1010, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1043, 1010, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1044, 1011, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1045, 1012, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1046, 1012, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1047, 1012, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1048, 1012, 1, 10000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1049, 1013, 1, 15000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1050, 1014, 1, 2500, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1051, 1015, 1, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1052, 1016, 1, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1053, 1017, 2, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1054, 4, 2, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1055, 3, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1056, 3, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1057, 3, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1058, 3, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1063, 1018, 1, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1064, 1018, 2, 15000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1065, 1018, 2, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1066, 1018, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1067, 1018, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1068, 1018, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1069, 1018, 1, 10000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1070, 1018, 1, 15000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1071, 1019, 1, 15000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1072, 1019, 1, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1073, 1019, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1074, 1019, 1, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1075, 1019, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1076, 1019, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1077, 1018, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1078, 1020, 1, 2500, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1079, 1021, 1, 15000, 25)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1080, 1021, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1081, 1021, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1082, 1021, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1083, 1021, 1, 10000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1084, 1021, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1085, 1021, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1086, 1020, 1, 2500, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1087, 1021, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1088, 1020, 2, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1089, 1020, 2, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1090, 1020, 2, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1091, 1020, 2, 10000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1092, 1022, 1, 2500, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1093, 1022, 1, 2500, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1094, 1023, 2, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1095, 1023, 1, 15000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1096, 1023, 1, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1097, 1023, 1, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1098, 1023, 1, 2500, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1099, 1023, 1, 2500, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1100, 1024, 1, 10000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1101, 1024, 1, 10000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1102, 1024, 1, 10000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1103, 1024, 1, 10000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1104, 1024, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1105, 1024, 1, 15000, 1025)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1106, 1023, 1, 15000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1109, 1027, 2, 2500, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1110, 1027, 2, 2500, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1111, 1026, 1, 10000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1112, 1026, 1, 10000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1113, 1026, 1, 10000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1114, 1026, 1, 10000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1115, 1025, 1, 15000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1116, 1025, 1, 2500, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1117, 1025, 1, 2500, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1118, 1025, 1, 10000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1119, 1025, 1, 10000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1120, 1025, 1, 10000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1121, 1025, 1, 10000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1122, 1028, 1, 15000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1123, 1028, 1, 209900, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1124, 1028, 1, 209900, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1125, 1028, 1, 209900, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1126, 1028, 1, 209900, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1127, 1029, 1, 15000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1128, 1029, 2, 15000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1129, 1029, 1, 2500, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1130, 1029, 1, 2500, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1131, 1029, 2, 10000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1132, 1029, 2, 10000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1133, 1029, 2, 10000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1134, 1029, 2, 10000, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1135, 1030, 1, 15000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1136, 1030, 2, 2500, 1024)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1137, 1030, 2, 2500, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1138, 1030, 1, 15000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1139, 1030, 3, 15000, 24)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1140, 1031, 2, 15000, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1141, 1031, 1, 15000, 24)
GO
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1142, 1031, 1, 209900, 21)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1143, 1031, 1, 209900, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1144, 1031, 1, 209900, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1145, 1031, 1, 209900, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1146, 1031, 1, 123, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1147, 1031, 1, 15000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1148, 1032, 1, 15000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1149, 1032, 1, 2500, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1151, 1033, 1, 15000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1152, 1033, 1, 2500, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1153, 1033, 1, 2500, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1154, 1033, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1155, 1033, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1156, 1033, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1157, 1033, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1158, 1033, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1159, 1033, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1160, 1033, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1161, 1033, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1162, 1033, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1163, 1033, 1, 15000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1164, 1034, 2, 19000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1165, 1034, 2, 190000, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1166, 1034, 1, 123, NULL)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1167, 1035, 3, 2500, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1168, 1035, 1, 2500, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1171, 1035, 1, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1172, 1035, 1, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1173, 1035, 2, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1174, 1033, 1, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1175, 1034, 1, 11, 19)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1176, 1034, 6, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1177, 1036, 1, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1178, 1036, 121, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1179, 1036, 12, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1180, 1036, 13, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1181, 1036, 7, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1182, 1036, 4, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1183, 1036, 1, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1184, 1037, 2, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1185, 1037, 1, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1186, 1037, 1, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1187, 1037, 1, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1188, 1037, 1, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1189, 1037, 2, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1190, 1042, 1, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1191, 1042, 1, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1192, 1042, 12, 18900, 4)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1194, 1043, 1, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1195, 1043, 3, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1196, 1045, 1, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1198, 1045, 1, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1200, 1045, 3, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1201, 1047, 1, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1202, 1047, 2, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1204, 1047, 1, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1205, 1047, 2, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1206, 1048, 2, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1207, 1048, 10, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1208, 1049, 2, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1209, 1049, 4, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1211, 1049, 12, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1212, 1051, 20, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1213, 1051, 122, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1214, 1050, 2, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1215, 1050, 100, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1216, 1050, 4, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1218, 1050, 2, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1219, 1052, 122, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1220, 1052, 1, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1221, 1053, 100, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1223, 1053, 100, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1225, 1053, 100, 10000, 1)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1226, 1054, 10, 15000, 3)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1227, 1054, 234, 2500, 2)
INSERT [dbo].[hoaDonCT] ([id_hoaDonCt], [id_hoaDon], [soLuong], [donGia], [id_sanPhamCt]) VALUES (1228, 1054, 100, 10000, 1)
SET IDENTITY_INSERT [dbo].[hoaDonCT] OFF
GO
SET IDENTITY_INSERT [dbo].[khachHang] ON 

INSERT [dbo].[khachHang] ([id_khachHang], [hoTen], [gioiTinh], [diaChi], [soDienThoai]) VALUES (1, N'Nguyễn văn A', 1, N'Hà Nội', 123456789)
INSERT [dbo].[khachHang] ([id_khachHang], [hoTen], [gioiTinh], [diaChi], [soDienThoai]) VALUES (2, N'Nguyễn văn B', 1, N'Cà mau', 123456789)
INSERT [dbo].[khachHang] ([id_khachHang], [hoTen], [gioiTinh], [diaChi], [soDienThoai]) VALUES (3, N'Trần thị B', 0, N'Hà Nội', 123456789)
INSERT [dbo].[khachHang] ([id_khachHang], [hoTen], [gioiTinh], [diaChi], [soDienThoai]) VALUES (4, N'Lê Thị C', 0, N'Yên bái', 123456789)
INSERT [dbo].[khachHang] ([id_khachHang], [hoTen], [gioiTinh], [diaChi], [soDienThoai]) VALUES (5, N'Lê Thị D', 0, N'Hà Nội', 123456789)
INSERT [dbo].[khachHang] ([id_khachHang], [hoTen], [gioiTinh], [diaChi], [soDienThoai]) VALUES (7, N'Hà Thanh ', 1, N'Hà Nội', 0)
INSERT [dbo].[khachHang] ([id_khachHang], [hoTen], [gioiTinh], [diaChi], [soDienThoai]) VALUES (8, N'Nguyễn Thị', 1, N'Vinh', 0)
INSERT [dbo].[khachHang] ([id_khachHang], [hoTen], [gioiTinh], [diaChi], [soDienThoai]) VALUES (9, N'Trần Văn', 0, N'Hà Nội', 123456779)
INSERT [dbo].[khachHang] ([id_khachHang], [hoTen], [gioiTinh], [diaChi], [soDienThoai]) VALUES (10, N'khách vippp', 1, N'Hà Nội', 1234567)
SET IDENTITY_INSERT [dbo].[khachHang] OFF
GO
SET IDENTITY_INSERT [dbo].[khuyenMai] ON 

INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (1, N'Khuyến mãi poly', N'%', N'20', CAST(N'2023-10-11' AS Date), CAST(N'2023-12-09' AS Date), 1)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (2, N'Khuyến mãi dự án 1', N'%', N'50', CAST(N'2023-10-13' AS Date), CAST(N'2023-11-25' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (3, N'Khuyến mãi 20-11', N'VNĐ', N'10000', CAST(N'2023-11-20' AS Date), CAST(N'2023-11-30' AS Date), 1)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (5, N'khuyến mãi poly2', N'VNĐ', N'90000', CAST(N'2023-10-10' AS Date), CAST(N'2023-10-31' AS Date), 1)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (6, N'khuyến mãi poly99', N'VNĐ', N'90000', CAST(N'2023-10-10' AS Date), CAST(N'2023-10-31' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (8, N'khuyến mãi poly99', N'VNĐ', N'11111', CAST(N'2023-10-10' AS Date), CAST(N'2023-10-31' AS Date), 1)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (9, N'khuyến mãi poly99', N'%', N'20', CAST(N'2023-10-10' AS Date), CAST(N'2023-10-31' AS Date), 1)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (11, N'khuyến mãi poly99', N'VNĐ', N'90000', CAST(N'2023-10-10' AS Date), CAST(N'2023-10-31' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (13, N'khuyến mãi poly99', N'VNĐ', N'90000', CAST(N'2023-10-10' AS Date), CAST(N'2023-10-31' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (14, N'khuyến mãi poly99', N'VNĐ', N'90000', CAST(N'2023-10-10' AS Date), CAST(N'2023-10-31' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (19, N'Khuyến mãi poly', N'%', N'20', CAST(N'2023-10-11' AS Date), CAST(N'2023-12-09' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (23, N'Khuyến mãi poly', N'%', N'20', CAST(N'2023-10-11' AS Date), CAST(N'2023-12-09' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (24, N'khuyến mãi poly99', N'VNĐ', N'11111', CAST(N'2023-10-10' AS Date), CAST(N'2023-10-31' AS Date), 1)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (27, N'Khuyến mãi ', N'%', N'20', CAST(N'2023-10-17' AS Date), CAST(N'2023-12-09' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (28, N'Khuyến mãi poly', N'%', N'20', CAST(N'2023-10-11' AS Date), CAST(N'2023-12-09' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (29, N'Khuyến mãi poly', N'%', N'20', CAST(N'2023-10-11' AS Date), CAST(N'2023-12-09' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (30, N'Khuyến mãi poly', N'%', N'20', CAST(N'2023-10-11' AS Date), CAST(N'2023-12-09' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (31, N'Khuyến mãi poly', N'%', N'20', CAST(N'2023-10-11' AS Date), CAST(N'2023-12-09' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (32, N'Khuyến mãi poly', N'%', N'20', CAST(N'2023-10-11' AS Date), CAST(N'2023-12-09' AS Date), 0)
INSERT [dbo].[khuyenMai] ([id_khuyenMai], [tenKhuyenMai], [loai], [giaTri], [ngayBatDau], [ngayKetThuc], [trangThai]) VALUES (33, N'Khuyến mãi poly', N'%', N'20', CAST(N'2023-10-11' AS Date), CAST(N'2023-12-09' AS Date), 0)
SET IDENTITY_INSERT [dbo].[khuyenMai] OFF
GO
SET IDENTITY_INSERT [dbo].[mau] ON 

INSERT [dbo].[mau] ([id_mau], [tenMau]) VALUES (1, N'xanh')
INSERT [dbo].[mau] ([id_mau], [tenMau]) VALUES (2, N'đỏ')
INSERT [dbo].[mau] ([id_mau], [tenMau]) VALUES (3, N'tím')
INSERT [dbo].[mau] ([id_mau], [tenMau]) VALUES (4, N'vàng')
INSERT [dbo].[mau] ([id_mau], [tenMau]) VALUES (5, N'đen')
INSERT [dbo].[mau] ([id_mau], [tenMau]) VALUES (6, N'hồng')
SET IDENTITY_INSERT [dbo].[mau] OFF
GO
SET IDENTITY_INSERT [dbo].[nhaCungCap] ON 

INSERT [dbo].[nhaCungCap] ([id_nhaCungCap], [tenNhaCungCap]) VALUES (1, N'mỹ')
INSERT [dbo].[nhaCungCap] ([id_nhaCungCap], [tenNhaCungCap]) VALUES (2, N'anh')
INSERT [dbo].[nhaCungCap] ([id_nhaCungCap], [tenNhaCungCap]) VALUES (3, N'Pháp')
INSERT [dbo].[nhaCungCap] ([id_nhaCungCap], [tenNhaCungCap]) VALUES (4, N'trung quốc')
SET IDENTITY_INSERT [dbo].[nhaCungCap] OFF
GO
SET IDENTITY_INSERT [dbo].[nhanVien] ON 

INSERT [dbo].[nhanVien] ([id_nhanVien], [hoTen], [gioiTinh], [soDt], [email], [diaChi], [id_taiKhoan], [trangThai]) VALUES (1, N'Hà Thanh Tùng New', 1, 123456, N'tung@gmail.com', N'Vĩnh Phúc', 1, 0)
INSERT [dbo].[nhanVien] ([id_nhanVien], [hoTen], [gioiTinh], [soDt], [email], [diaChi], [id_taiKhoan], [trangThai]) VALUES (2, N'Nguyễn Đức Duy', 0, 123456, N'duy@gmail.com', N'Hà Nội', 4, 0)
INSERT [dbo].[nhanVien] ([id_nhanVien], [hoTen], [gioiTinh], [soDt], [email], [diaChi], [id_taiKhoan], [trangThai]) VALUES (3, N'Nguyễn Huy hân', 0, 123456, N'huan@gmail.com', N'Đà Nẵng', 3, 1)
INSERT [dbo].[nhanVien] ([id_nhanVien], [hoTen], [gioiTinh], [soDt], [email], [diaChi], [id_taiKhoan], [trangThai]) VALUES (4, N'Nguyễn Trí Sơn', 1, 123456, N'son@gmail.com', N'Hà Nội', 2, 0)
INSERT [dbo].[nhanVien] ([id_nhanVien], [hoTen], [gioiTinh], [soDt], [email], [diaChi], [id_taiKhoan], [trangThai]) VALUES (5, N'Nguyễn Quang Quyết New', 1, 123456, N'quuyet@gmail.com', N'Tây Nguyên', 5, 0)
INSERT [dbo].[nhanVien] ([id_nhanVien], [hoTen], [gioiTinh], [soDt], [email], [diaChi], [id_taiKhoan], [trangThai]) VALUES (6, N'Nguyễn Quang Quyết', 0, 123456, N'quuyet@gmail.com', N'hà Nội', 6, 0)
INSERT [dbo].[nhanVien] ([id_nhanVien], [hoTen], [gioiTinh], [soDt], [email], [diaChi], [id_taiKhoan], [trangThai]) VALUES (7, N'Hà Thanh Tùng', 1, 1234455, N'tung@gmail', N'cà mau', 7, 1)
SET IDENTITY_INSERT [dbo].[nhanVien] OFF
GO
SET IDENTITY_INSERT [dbo].[sanPham] ON 

INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1, N'Giày đá bóng adidas', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (2, N'Giày đá bóng puma', N'Sản phẩm mới')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (3, N'Giày chạy Bộ poly new', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (4, N'Giày bóng rổ nike', N'sản phẩm mới')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (5, N'Giày nhảy cao adidas neww', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (6, N'Giày chạy Bộ poly333', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (7, N'Giày nhảy cao adidas', NULL)
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (10, N'giày đá bóng neww', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (11, N'abcccc', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (13, N'giày đá bóng', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (14, N'tùng', N'new')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (15, N'tungaaa', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (16, N'giày siêu cấp ', N'new')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1016, N'Giày nhảy cao abc', N'new
')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1017, N'Giày nhảy ', N'new update')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1018, N'Sản phẩm mới neww', N'new')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1019, N'Sản phẩm mới', N'new')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1020, N'sản phẩm mới tạo', N'aaaa')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1021, N'daily', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1022, N'sản phẩm cao cấp new', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1023, N'giày neww', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1024, N'giày neww22', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1025, N'giày new221', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1026, N'giày new1', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1027, N'giày new11', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1028, N'giày new11a', N'')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1029, N'giày mới 01', N'new')
INSERT [dbo].[sanPham] ([id_sanPham], [tenSanPham], [ghiChu]) VALUES (1030, N'sản phẩm giày neww', N'mới')
SET IDENTITY_INSERT [dbo].[sanPham] OFF
GO
SET IDENTITY_INSERT [dbo].[sanPhamCt] ON 

INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1, 1, 2, 2, 1, 4, 3, 10000, 20, 1495, NULL)
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (2, 3, 1, 4, 3, 2, 1, 2500, 41, 1764, NULL)
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (3, 4, 3, 1, 4, 4, 2, 15000, 38, 1871, NULL)
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (4, 2, 2, 3, 2, 1, 4, 18900, 38, 2024, NULL)
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (5, 5, 4, 3, 1, 3, 5, 299900, 42, 2036, NULL)
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (6, 1, 3, 1, 3, 2, 4, 209900, 32, 2026, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (9, 2, 1, 1, 2, 2, 3, 222, 22, 2036, N'1111')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (19, 1, 2, 1, 2, 1, 2, 11, 11, 2036, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (20, 5, 4, 3, 1, 3, 5, 299900, 42, 2036, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (21, 15, 1, 1, 1, 1, 1, 12233, 12, 2036, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (22, 5, 4, 1, 1, 3, 5, 299900, 42, 2036, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (23, 16, 3, 3, 2, 4, 5, 190000, 40, 2036, N'new')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (24, 2, 1, 2, 1, 3, 5, 1234444, 12, 2036, N'neww')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (25, 2, 4, 2, 1, 3, 5, 122222, 12, 2036, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (26, 1, 5, 3, 3, 4, 3, 23001, 35, 2036, N'new like')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1023, 3, 1, 1, 1, 1, 1, 122222, 12, 2036, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1024, 1016, 2, 2, 1, 1, 1, 123, 99, 2036, N'neww')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1025, 1019, 3, 5, 1, 2, 2, 190000, 32, 2036, N'new')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1026, 1020, 1, 1, 1, 1, 1, 199000, 12, 20, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1027, 1020, 1, 1, 1, 1, 1, 199000, 12, 20, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1028, 1021, 1, 1, 1, 1, 1, 500000, 45, 40, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1030, 1021, 2, 2, 2, 2, 2, 500000, 45, 40, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1031, 5, 2, 2, 2, 2, 2, 299900, 42, 2036, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1032, 1022, 1, 1, 1, 1, 1, 199999, 23, 10, N'new')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1033, 1022, 2, 2, 2, 2, 2, 199999, 23, 10, N'new')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1034, 1023, 1, 1, 1, 1, 1, 123333, 32, 12, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1035, 1023, 2, 2, 2, 2, 3, 123333, 32, 12, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1036, 1028, 1, 1, 1, 1, 1, 1234444, 30, 10, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1037, 1028, 2, 1, 1, 1, 1, 1234444, 30, 10, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1038, 1028, 1, 2, 1, 1, 1, 1234444, 30, 10, N'')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1039, 1030, 1, 1, 1, 1, 1, 199000, 41, 21, N'new')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1040, 1030, 2, 1, 1, 1, 1, 199000, 41, 21, N'new')
INSERT [dbo].[sanPhamCt] ([id_sanPhamCt], [id_sanPham], [id_theLoai], [id_chatLieu], [id_thuongHieu], [id_nhaCungCap], [id_mau], [gia], [size], [soLuong], [ghiChu]) VALUES (1041, 1030, 2, 2, 1, 1, 1, 199000, 41, 21, N'new')
SET IDENTITY_INSERT [dbo].[sanPhamCt] OFF
GO
SET IDENTITY_INSERT [dbo].[taiKhoan] ON 

INSERT [dbo].[taiKhoan] ([id_taiKHoan], [tenDangNhap], [matKhau], [vaiTro]) VALUES (1, N'tungHa', N'1234567', 0)
INSERT [dbo].[taiKhoan] ([id_taiKHoan], [tenDangNhap], [matKhau], [vaiTro]) VALUES (2, N'sonTri', N'1234567', 0)
INSERT [dbo].[taiKhoan] ([id_taiKHoan], [tenDangNhap], [matKhau], [vaiTro]) VALUES (3, N'huanHuy', N'1234567', 1)
INSERT [dbo].[taiKhoan] ([id_taiKHoan], [tenDangNhap], [matKhau], [vaiTro]) VALUES (4, N'ducDuy', N'1234567', 0)
INSERT [dbo].[taiKhoan] ([id_taiKHoan], [tenDangNhap], [matKhau], [vaiTro]) VALUES (5, N'quangQuyet', N'123123', 1)
INSERT [dbo].[taiKhoan] ([id_taiKHoan], [tenDangNhap], [matKhau], [vaiTro]) VALUES (6, N'user1', N'12341234', 1)
INSERT [dbo].[taiKhoan] ([id_taiKHoan], [tenDangNhap], [matKhau], [vaiTro]) VALUES (7, N'Tung123', N'123456', 1)
SET IDENTITY_INSERT [dbo].[taiKhoan] OFF
GO
SET IDENTITY_INSERT [dbo].[theloai] ON 

INSERT [dbo].[theloai] ([id_theLoai], [tenTheLoai]) VALUES (1, N'chạy')
INSERT [dbo].[theloai] ([id_theLoai], [tenTheLoai]) VALUES (2, N'đá bóng')
INSERT [dbo].[theloai] ([id_theLoai], [tenTheLoai]) VALUES (3, N'bóng rổ')
INSERT [dbo].[theloai] ([id_theLoai], [tenTheLoai]) VALUES (4, N'nhảy cao')
INSERT [dbo].[theloai] ([id_theLoai], [tenTheLoai]) VALUES (5, N'bay')
SET IDENTITY_INSERT [dbo].[theloai] OFF
GO
SET IDENTITY_INSERT [dbo].[thuongHieu] ON 

INSERT [dbo].[thuongHieu] ([id_thuongHieu], [tenThuongHieu]) VALUES (1, N'adidas')
INSERT [dbo].[thuongHieu] ([id_thuongHieu], [tenThuongHieu]) VALUES (2, N'puma')
INSERT [dbo].[thuongHieu] ([id_thuongHieu], [tenThuongHieu]) VALUES (3, N'poly')
INSERT [dbo].[thuongHieu] ([id_thuongHieu], [tenThuongHieu]) VALUES (4, N'nike')
SET IDENTITY_INSERT [dbo].[thuongHieu] OFF
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD FOREIGN KEY([id_khachHang])
REFERENCES [dbo].[khachHang] ([id_khachHang])
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD FOREIGN KEY([id_khuyenMai])
REFERENCES [dbo].[khuyenMai] ([id_khuyenMai])
GO
ALTER TABLE [dbo].[hoaDon]  WITH CHECK ADD FOREIGN KEY([id_nhanVien])
REFERENCES [dbo].[nhanVien] ([id_nhanVien])
GO
ALTER TABLE [dbo].[hoaDonCT]  WITH CHECK ADD FOREIGN KEY([id_hoaDon])
REFERENCES [dbo].[hoaDon] ([id_hoaDon])
GO
ALTER TABLE [dbo].[hoaDonCT]  WITH CHECK ADD FOREIGN KEY([id_sanPhamCt])
REFERENCES [dbo].[sanPhamCt] ([id_sanPhamCt])
GO
ALTER TABLE [dbo].[nhanVien]  WITH CHECK ADD FOREIGN KEY([id_taiKhoan])
REFERENCES [dbo].[taiKhoan] ([id_taiKHoan])
GO
ALTER TABLE [dbo].[sanPhamCt]  WITH CHECK ADD FOREIGN KEY([id_chatLieu])
REFERENCES [dbo].[chatLieu] ([id_chatLieu])
GO
ALTER TABLE [dbo].[sanPhamCt]  WITH CHECK ADD FOREIGN KEY([id_mau])
REFERENCES [dbo].[mau] ([id_mau])
GO
ALTER TABLE [dbo].[sanPhamCt]  WITH CHECK ADD FOREIGN KEY([id_nhaCungCap])
REFERENCES [dbo].[nhaCungCap] ([id_nhaCungCap])
GO
ALTER TABLE [dbo].[sanPhamCt]  WITH CHECK ADD FOREIGN KEY([id_sanPham])
REFERENCES [dbo].[sanPham] ([id_sanPham])
GO
ALTER TABLE [dbo].[sanPhamCt]  WITH CHECK ADD FOREIGN KEY([id_theLoai])
REFERENCES [dbo].[theloai] ([id_theLoai])
GO
ALTER TABLE [dbo].[sanPhamCt]  WITH CHECK ADD FOREIGN KEY([id_thuongHieu])
REFERENCES [dbo].[thuongHieu] ([id_thuongHieu])
GO
USE [master]
GO
ALTER DATABASE [DA_banGiay_BG_Seven] SET  READ_WRITE 
GO
