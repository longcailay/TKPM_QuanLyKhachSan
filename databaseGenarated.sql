USE [master]
GO
/****** Object:  Database [QuanLyKhachSan]    Script Date: 8/25/2020 8:18:28 AM ******/
CREATE DATABASE [QuanLyKhachSan]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyKhachSan', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\QuanLyKhachSan.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyKhachSan_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\QuanLyKhachSan_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [QuanLyKhachSan] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyKhachSan].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyKhachSan] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyKhachSan] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLyKhachSan] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyKhachSan] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyKhachSan] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyKhachSan] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyKhachSan] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyKhachSan] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyKhachSan] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyKhachSan] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyKhachSan] SET QUERY_STORE = OFF
GO
USE [QuanLyKhachSan]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [QuanLyKhachSan]
GO
/****** Object:  Table [dbo].[CHI_TIET_HOA_DON]    Script Date: 8/25/2020 8:18:28 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHI_TIET_HOA_DON](
	[HoaDon] [int] NOT NULL,
	[PhieuThue] [int] NOT NULL,
	[SoNgay] [int] NULL,
	[DonGia] [money] NULL,
	[PhuThu] [float] NULL,
	[Tien] [money] NULL,
 CONSTRAINT [PK_CHI_TIET_HOA_DON] PRIMARY KEY CLUSTERED 
(
	[HoaDon] ASC,
	[PhieuThue] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CHI_TIET_PHIEU_THUE]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CHI_TIET_PHIEU_THUE](
	[PhieuThue] [int] NOT NULL,
	[Khach] [int] NOT NULL,
 CONSTRAINT [PK_CHI_TIET_PHIEU_THUE] PRIMARY KEY CLUSTERED 
(
	[PhieuThue] ASC,
	[Khach] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOA_DON]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOA_DON](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[KhachHang] [nvarchar](50) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[TongTien] [money] NULL,
	[NguoiDung] [int] NULL,
 CONSTRAINT [PK_HOA_DON] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHACH]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHACH](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](30) NULL,
	[CMND] [nvarchar](15) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[LoaiKhach] [int] NOT NULL,
 CONSTRAINT [PK_KHACH] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOAI_KHACH]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAI_KHACH](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TenLoai] [nvarchar](50) NULL,
	[PhuThu] [float] NULL,
 CONSTRAINT [PK_LOAI_KHACH] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOAI_PHONG]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOAI_PHONG](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TenLoai] [nvarchar](50) NULL,
	[DonGia] [money] NULL,
	[SL_KhachBinhThuong] [int] NULL,
	[SL_KhachToiDa] [int] NULL,
	[PhuThu] [float] NULL,
 CONSTRAINT [PK_LOAI_PHONG] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NGUOI_DUNG]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NGUOI_DUNG](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[CMND] [nvarchar](15) NULL,
	[SDT] [nvarchar](15) NULL,
	[DiaChi] [nvarchar](50) NULL,
	[TaiKhoan] [nvarchar](50) NULL,
	[MatKhau] [nvarchar](50) NULL,
	[TinhTrang] [int] NULL,
	[PhanQuyen] [int] NULL,
 CONSTRAINT [PK_NGUOI_DUNG] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHAN_QUYEN]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHAN_QUYEN](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TenPhanQuyen] [nvarchar](30) NULL,
	[GhiChu] [nvarchar](50) NULL,
 CONSTRAINT [PK_PHAN_QUYEN] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHIEU_THUE]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHIEU_THUE](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NgayThue] [datetime] NULL,
	[NgayKetThuc] [datetime] NULL,
	[TinhTrang] [int] NULL,
	[Phong] [int] NOT NULL,
	[NguoiDung] [int] NOT NULL,
 CONSTRAINT [PK_PHIEU_THUE] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PHONG]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PHONG](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TenPhong] [nvarchar](10) NULL,
	[GhiChu] [nvarchar](300) NULL,
	[TinhTrang] [int] NULL,
	[LoaiPhong] [int] NULL,
 CONSTRAINT [PK_PHONG] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CHI_TIET_HOA_DON] ([HoaDon], [PhieuThue], [SoNgay], [DonGia], [PhuThu], [Tien]) VALUES (1, 1, 2, 150000.0000, 75000, 375000.0000)
INSERT [dbo].[CHI_TIET_HOA_DON] ([HoaDon], [PhieuThue], [SoNgay], [DonGia], [PhuThu], [Tien]) VALUES (1, 2, 2, 150000.0000, 0, 300000.0000)
INSERT [dbo].[CHI_TIET_HOA_DON] ([HoaDon], [PhieuThue], [SoNgay], [DonGia], [PhuThu], [Tien]) VALUES (1, 3, 2, 150000.0000, 262500, 562500.0000)
INSERT [dbo].[CHI_TIET_HOA_DON] ([HoaDon], [PhieuThue], [SoNgay], [DonGia], [PhuThu], [Tien]) VALUES (2, 7, 3, 170000.0000, 446250, 956250.0000)
INSERT [dbo].[CHI_TIET_HOA_DON] ([HoaDon], [PhieuThue], [SoNgay], [DonGia], [PhuThu], [Tien]) VALUES (2, 8, 3, 170000.0000, 446250, 956250.0000)
INSERT [dbo].[CHI_TIET_HOA_DON] ([HoaDon], [PhieuThue], [SoNgay], [DonGia], [PhuThu], [Tien]) VALUES (2, 12, 5, 150000.0000, 375000, 1125000.0000)
INSERT [dbo].[CHI_TIET_HOA_DON] ([HoaDon], [PhieuThue], [SoNgay], [DonGia], [PhuThu], [Tien]) VALUES (2, 13, 12, 200000.0000, 0, 2400000.0000)
INSERT [dbo].[CHI_TIET_HOA_DON] ([HoaDon], [PhieuThue], [SoNgay], [DonGia], [PhuThu], [Tien]) VALUES (3, 14, 4, 150000.0000, 150000, 750000.0000)
INSERT [dbo].[CHI_TIET_HOA_DON] ([HoaDon], [PhieuThue], [SoNgay], [DonGia], [PhuThu], [Tien]) VALUES (4, 10, 5, 170000.0000, 743750, 1593750.0000)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (1, 1)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (1, 2)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (1, 3)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (2, 4)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (2, 5)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (3, 1)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (3, 23)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (3, 27)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (4, 9)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (4, 10)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (4, 11)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (5, 12)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (5, 13)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (5, 16)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (6, 14)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (6, 15)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (6, 17)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (7, 18)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (7, 19)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (7, 20)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (8, 21)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (8, 22)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (8, 23)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (9, 24)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (9, 25)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (9, 26)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (10, 27)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (10, 28)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (10, 29)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (11, 30)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (12, 31)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (12, 32)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (13, 33)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (13, 34)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (14, 35)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (14, 36)
INSERT [dbo].[CHI_TIET_PHIEU_THUE] ([PhieuThue], [Khach]) VALUES (14, 37)
SET IDENTITY_INSERT [dbo].[HOA_DON] ON 

INSERT [dbo].[HOA_DON] ([ID], [KhachHang], [DiaChi], [TongTien], [NguoiDung]) VALUES (1, N'Công ty KinhDo VietNam', N'TP Hồ Chí Minh', 1237500.0000, 2)
INSERT [dbo].[HOA_DON] ([ID], [KhachHang], [DiaChi], [TongTien], [NguoiDung]) VALUES (2, N'Tập đoàn Hòa Phát', N'Hà Nội', 5437500.0000, 1)
INSERT [dbo].[HOA_DON] ([ID], [KhachHang], [DiaChi], [TongTien], [NguoiDung]) VALUES (3, N'Nguyễn Thị Thanh Hương', N'Hồ Chí Minh', 750000.0000, 1)
INSERT [dbo].[HOA_DON] ([ID], [KhachHang], [DiaChi], [TongTien], [NguoiDung]) VALUES (4, N'Bi Rain', N'Hàn Quốc', 1593750.0000, 1)
SET IDENTITY_INSERT [dbo].[HOA_DON] OFF
SET IDENTITY_INSERT [dbo].[KHACH] ON 

INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (1, N'Nguyễn Long Hồ', N'312370529', N'Mỹ Tho, Tiền Giang', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (2, N'Nguyễn Quang Hải', N'232525261', N'Q8, TP Hồ Chí Minh', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (3, N'Nguyễn Văn Nam', N'321489567', N'Q1, TP Hồ Chí Minh', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (4, N'Nguyễn Thị Giang', N'312470456', N'Quảng Ngãi', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (5, N'Nguyễn Thị Hương', N'2124542154', N'Quảng Ngãi', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (6, N'Võ Văn Tuấn', N'2124545487', N'Hải Phòng', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (7, N'Trần Văn Cường', N'2124545548', N'Quảng Ninh', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (8, N'Võ Văn Minh', N'2124545582', N'Cà Mau', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (9, N'Nguyễn Văn An', N'456879546', N'Sơn Tịnh, Quảng Ngãi', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (10, N'Nguyễn Văn Hiếu', N'465879456', N'Hà Nội', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (11, N'Trần Cường', N'465879488', N'Phú Yên', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (12, N'Nguyễn Duy Nhất', N'465879555', N'Tây Ninh', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (13, N'Nguyễn Văn Hoàng', N'123456789', N'Sơn Tịnh, Quảng Ngãi', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (14, N'Nguyễn Phú Bình', N'54879858749', N'Sơn Tịnh, Quảng Ngãi', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (15, N'Phạm Thị Tuyết', N'798546236', N'Sơn Tịnh, Quảng Ngãi', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (16, N'Bill Gates', N'235464647987', N' Seattle, Washington, Hoa Kỳ', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (17, N'Mark Zuckerberg', N'235464647986', N'New York, Hoa Kỳ', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (18, N'Elon Musk', N'21545879565', N'Hoa Kỳ', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (19, N'Cristiano Ronaldo', N'46587953214', N'Bồ Đào Nha', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (20, N'Lionel Messi', N'46587953999', N'Argentina', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (21, N'Mesut Ozil', N'547875215487', N'Đức', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (22, N'Robin van Persie', N'5487895656', N'Hà Lan', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (23, N'Arjen Robben', N'5487895656', N'Hà Lan', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (24, N'Thomas Muller', N'5487895656', N'Đức', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (25, N'Robert Lewandowski', N'5487895446', N'Ba Lan', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (26, N'Justin Bieber', N'5422895656', N'Canada', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (27, N'Taylor Swift', N'5487895656', N'Hoa Kỳ', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (28, N'Châu Tinh Tinh', N'2100878795', N'HongKong, Trung Quốc', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (29, N'Bi Rain', N'215478965', N'Hàn Quốc', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (30, N'Lee Min Ho', N'215478987', N'Hàn Quốc', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (31, N'Ronaldo', N'12345678', N'Bồ Đào Nha', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (32, N'Messi', N'87654321', N'Argentina', 2)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (33, N'Nguyễn Thành Nam', N'22222222222', N'Huế', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (34, N'Nguyễn Thành Trung', N'555555555555', N'Huế', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (35, N'Nguyễn Thị Thanh Hương', N'456789654', N'Hồ Chí Minh', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (36, N'Nguyễn Thị Mỹ Quyên', N'5465465465', N'Hồ Chí Minh', 1)
INSERT [dbo].[KHACH] ([ID], [HoTen], [CMND], [DiaChi], [LoaiKhach]) VALUES (37, N'Trần Thị Thảo', N'88798798798', N'Hồ Chí Minh', 1)
SET IDENTITY_INSERT [dbo].[KHACH] OFF
SET IDENTITY_INSERT [dbo].[LOAI_KHACH] ON 

INSERT [dbo].[LOAI_KHACH] ([ID], [TenLoai], [PhuThu]) VALUES (1, N'Nội địa', 1)
INSERT [dbo].[LOAI_KHACH] ([ID], [TenLoai], [PhuThu]) VALUES (2, N'Nước ngoài', 1.5)
SET IDENTITY_INSERT [dbo].[LOAI_KHACH] OFF
SET IDENTITY_INSERT [dbo].[LOAI_PHONG] ON 

INSERT [dbo].[LOAI_PHONG] ([ID], [TenLoai], [DonGia], [SL_KhachBinhThuong], [SL_KhachToiDa], [PhuThu]) VALUES (1, N'Loại A', 150000.0000, 2, 3, 0.25)
INSERT [dbo].[LOAI_PHONG] ([ID], [TenLoai], [DonGia], [SL_KhachBinhThuong], [SL_KhachToiDa], [PhuThu]) VALUES (2, N'Loại B', 170000.0000, 2, 3, 0.25)
INSERT [dbo].[LOAI_PHONG] ([ID], [TenLoai], [DonGia], [SL_KhachBinhThuong], [SL_KhachToiDa], [PhuThu]) VALUES (3, N'Loại C', 200000.0000, 2, 3, 0.25)
SET IDENTITY_INSERT [dbo].[LOAI_PHONG] OFF
SET IDENTITY_INSERT [dbo].[NGUOI_DUNG] ON 

INSERT [dbo].[NGUOI_DUNG] ([ID], [HoTen], [CMND], [SDT], [DiaChi], [TaiKhoan], [MatKhau], [TinhTrang], [PhanQuyen]) VALUES (1, N'Nguyễn Long Hồ', N'3123484721', N'0329435151', N'Cai Lậy, Tiền Giang', N'admin', N'admin', 1, 1)
INSERT [dbo].[NGUOI_DUNG] ([ID], [HoTen], [CMND], [SDT], [DiaChi], [TaiKhoan], [MatKhau], [TinhTrang], [PhanQuyen]) VALUES (2, N'Nguyễn Long Giang', N'3123484722', N'0329435152', N'Châu Thành, Tiền Giang', N'user1', N'user1', 1, 2)
INSERT [dbo].[NGUOI_DUNG] ([ID], [HoTen], [CMND], [SDT], [DiaChi], [TaiKhoan], [MatKhau], [TinhTrang], [PhanQuyen]) VALUES (3, N'Nguyễn Long Sơn', N'3123484723', N'0329435153', N'Tân Phước, Tiền Giang', N'user2', N'user2', 1, 2)
SET IDENTITY_INSERT [dbo].[NGUOI_DUNG] OFF
SET IDENTITY_INSERT [dbo].[PHAN_QUYEN] ON 

INSERT [dbo].[PHAN_QUYEN] ([ID], [TenPhanQuyen], [GhiChu]) VALUES (1, N'Admin', N'Phân quyền giành cho Admin')
INSERT [dbo].[PHAN_QUYEN] ([ID], [TenPhanQuyen], [GhiChu]) VALUES (2, N'Nhân viên', N'Phân quyền giành cho nhân viên')
SET IDENTITY_INSERT [dbo].[PHAN_QUYEN] OFF
SET IDENTITY_INSERT [dbo].[PHIEU_THUE] ON 

INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (1, CAST(N'2020-06-10T00:00:00.000' AS DateTime), CAST(N'2020-06-12T00:00:00.000' AS DateTime), 1, 1, 2)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (2, CAST(N'2020-06-10T00:00:00.000' AS DateTime), CAST(N'2020-06-12T00:00:00.000' AS DateTime), 1, 11, 2)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (3, CAST(N'2020-06-10T00:00:00.000' AS DateTime), CAST(N'2020-06-12T00:00:00.000' AS DateTime), 1, 21, 1)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (4, CAST(N'2020-08-14T00:00:00.000' AS DateTime), CAST(N'2020-08-15T00:00:00.000' AS DateTime), 0, 4, 3)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (5, CAST(N'2020-08-14T00:00:00.000' AS DateTime), CAST(N'2020-08-16T00:00:00.000' AS DateTime), 0, 1, 2)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (6, CAST(N'2020-08-14T00:00:00.000' AS DateTime), CAST(N'2020-08-10T00:00:00.000' AS DateTime), 0, 5, 3)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (7, CAST(N'2020-07-15T00:00:00.000' AS DateTime), CAST(N'2020-07-18T00:00:00.000' AS DateTime), 1, 16, 1)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (8, CAST(N'2020-07-15T00:00:00.000' AS DateTime), CAST(N'2020-07-18T00:00:00.000' AS DateTime), 1, 17, 2)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (9, CAST(N'2020-08-10T00:00:00.000' AS DateTime), CAST(N'2020-08-12T00:00:00.000' AS DateTime), 0, 18, 2)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (10, CAST(N'2020-08-10T00:00:00.000' AS DateTime), CAST(N'2020-08-15T00:00:00.000' AS DateTime), 1, 19, 2)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (11, CAST(N'2020-08-10T00:00:00.000' AS DateTime), CAST(N'2020-08-12T00:00:00.000' AS DateTime), 0, 20, 1)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (12, CAST(N'2020-07-17T00:00:00.000' AS DateTime), CAST(N'2020-07-22T00:00:00.000' AS DateTime), 1, 10, 1)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (13, CAST(N'2020-07-13T00:00:00.000' AS DateTime), CAST(N'2020-07-25T00:00:00.000' AS DateTime), 1, 21, 1)
INSERT [dbo].[PHIEU_THUE] ([ID], [NgayThue], [NgayKetThuc], [TinhTrang], [Phong], [NguoiDung]) VALUES (14, CAST(N'2020-08-01T00:00:00.000' AS DateTime), CAST(N'2020-08-05T00:00:00.000' AS DateTime), 1, 7, 1)
SET IDENTITY_INSERT [dbo].[PHIEU_THUE] OFF
SET IDENTITY_INSERT [dbo].[PHONG] ON 

INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (1, N'101', N'Hỏng điều hòa', 1, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (2, N'102', N'Vòi sen hỏng', 0, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (3, N'103', N'Tivi hỏng', 0, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (4, N'104', N'Không có', 1, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (5, N'105', N'Không có', 1, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (6, N'106', N'Không có', 0, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (7, N'107', N'Đang sửa trần nhà', 0, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (8, N'108', N'Không có', 0, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (9, N'109', N'Không có', 0, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (10, N'110', N'Không có', 0, 1)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (11, N'201', N'Vòi rửa tay bị tắt nghẽn', 0, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (12, N'202', N'Không có', 0, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (13, N'203', N'Không có', 0, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (14, N'204', N'Ti vi bị hỏng', 0, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (15, N'205', N'Không có', 0, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (16, N'206', N'Không có', 0, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (17, N'207', N'Không có', 0, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (18, N'208', N'Không có', 1, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (19, N'209', N'Không có', 0, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (20, N'210', N'Không có', 1, 2)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (21, N'301', N'Không có', 0, 3)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (22, N'302', N'Không có', 0, 3)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (23, N'303', N'Không có', 0, 3)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (24, N'304', N'Không có', 0, 3)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (25, N'305', N'Không có', 0, 3)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (26, N'306', N'Không có', 0, 3)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (27, N'307', N'Không có', 0, 3)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (28, N'308', N'Không có', 0, 3)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (29, N'309', N'Không có', 0, 3)
INSERT [dbo].[PHONG] ([ID], [TenPhong], [GhiChu], [TinhTrang], [LoaiPhong]) VALUES (30, N'310', N'Không có', 0, 3)
SET IDENTITY_INSERT [dbo].[PHONG] OFF
ALTER TABLE [dbo].[CHI_TIET_HOA_DON]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([HoaDon])
REFERENCES [dbo].[HOA_DON] ([ID])
GO
ALTER TABLE [dbo].[CHI_TIET_HOA_DON] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[CHI_TIET_HOA_DON]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_PhieuThue] FOREIGN KEY([PhieuThue])
REFERENCES [dbo].[PHIEU_THUE] ([ID])
GO
ALTER TABLE [dbo].[CHI_TIET_HOA_DON] CHECK CONSTRAINT [FK_ChiTietHoaDon_PhieuThue]
GO
ALTER TABLE [dbo].[CHI_TIET_PHIEU_THUE]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuThue_Khach] FOREIGN KEY([Khach])
REFERENCES [dbo].[KHACH] ([ID])
GO
ALTER TABLE [dbo].[CHI_TIET_PHIEU_THUE] CHECK CONSTRAINT [FK_ChiTietPhieuThue_Khach]
GO
ALTER TABLE [dbo].[CHI_TIET_PHIEU_THUE]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuThue_PhieuThue] FOREIGN KEY([PhieuThue])
REFERENCES [dbo].[PHIEU_THUE] ([ID])
GO
ALTER TABLE [dbo].[CHI_TIET_PHIEU_THUE] CHECK CONSTRAINT [FK_ChiTietPhieuThue_PhieuThue]
GO
ALTER TABLE [dbo].[HOA_DON]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NguoiDung] FOREIGN KEY([NguoiDung])
REFERENCES [dbo].[NGUOI_DUNG] ([ID])
GO
ALTER TABLE [dbo].[HOA_DON] CHECK CONSTRAINT [FK_HoaDon_NguoiDung]
GO
ALTER TABLE [dbo].[KHACH]  WITH CHECK ADD  CONSTRAINT [FK_Khach_LoaiKhach] FOREIGN KEY([LoaiKhach])
REFERENCES [dbo].[LOAI_KHACH] ([ID])
GO
ALTER TABLE [dbo].[KHACH] CHECK CONSTRAINT [FK_Khach_LoaiKhach]
GO
ALTER TABLE [dbo].[NGUOI_DUNG]  WITH CHECK ADD  CONSTRAINT [FK_NguoiDung_PhanQuyen] FOREIGN KEY([PhanQuyen])
REFERENCES [dbo].[PHAN_QUYEN] ([ID])
GO
ALTER TABLE [dbo].[NGUOI_DUNG] CHECK CONSTRAINT [FK_NguoiDung_PhanQuyen]
GO
ALTER TABLE [dbo].[PHIEU_THUE]  WITH CHECK ADD  CONSTRAINT [FK_PhieuThue_NguoiDung] FOREIGN KEY([NguoiDung])
REFERENCES [dbo].[NGUOI_DUNG] ([ID])
GO
ALTER TABLE [dbo].[PHIEU_THUE] CHECK CONSTRAINT [FK_PhieuThue_NguoiDung]
GO
ALTER TABLE [dbo].[PHIEU_THUE]  WITH CHECK ADD  CONSTRAINT [FK_PhieuThue_Phong] FOREIGN KEY([Phong])
REFERENCES [dbo].[PHONG] ([ID])
GO
ALTER TABLE [dbo].[PHIEU_THUE] CHECK CONSTRAINT [FK_PhieuThue_Phong]
GO
ALTER TABLE [dbo].[PHONG]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([LoaiPhong])
REFERENCES [dbo].[LOAI_PHONG] ([ID])
GO
ALTER TABLE [dbo].[PHONG] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
/****** Object:  StoredProcedure [dbo].[pro_BaoCaoMatDoSuDungPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_BaoCaoMatDoSuDungPhong] @idPhong int, @thang NVARCHAR(15)
as
	select sum(cthd.SoNgay)
	from CHI_TIET_HOA_DON cthd, PHIEU_THUE pt, PHONG p
	where cthd.PhieuThue = pt.ID and pt.Phong = p.ID and p.ID = @idPhong and pt.NgayKetThuc between @thang AND EOMONTH(@thang)
GO
/****** Object:  StoredProcedure [dbo].[pro_BaoCaoTheoLoaiPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_BaoCaoTheoLoaiPhong] @idLoaiPhong int, @thang NVARCHAR(15)
as
	select sum(cthd.Tien)
	from CHI_TIET_HOA_DON cthd, PHIEU_THUE pt, PHONG p, LOAI_PHONG lp
	where cthd.PhieuThue = pt.ID and pt.Phong = p.ID and p.LoaiPhong = lp.ID and lp.ID = @idLoaiPhong and pt.NgayKetThuc between @thang AND EOMONTH(@thang)
GO
/****** Object:  StoredProcedure [dbo].[pro_LayLoaiKhachTheoID]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LayLoaiKhachTheoID] @idLoaiKhach INT
AS
	SELECT * FROM LOAI_KHACH WHERE ID = @idLoaiKhach
GO
/****** Object:  StoredProcedure [dbo].[pro_LayThongTinPhongTheoTenPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LayThongTinPhongTheoTenPhong] @tenPhong NVARCHAR(20)
AS
	SELECT P.*, LP.TenLoai FROM PHONG AS P, LOAI_PHONG AS LP WHERE TenPhong = @TenPhong AND P.LoaiPhong = LP.ID
GO
/****** Object:  StoredProcedure [dbo].[pro_LoadChiTietPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LoadChiTietPhong] @ID INT
AS
	select P.*, PT.NgayThue
	from PHONG AS P
	LEFT JOIN PHIEU_THUE AS PT
	ON P.ID = PT.Phong AND PT.TinhTrang = 0
	WHERE P.ID = @ID and P.TinhTrang != -1
GO
/****** Object:  StoredProcedure [dbo].[pro_LoadDanhSachHoaDonTheoMaHoaDonVaKhachHang]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LoadDanhSachHoaDonTheoMaHoaDonVaKhachHang] @idHoaDon int, @khachHang nvarchar(50)
AS
	IF (@idHoaDon = -1 AND @khachHang = N'Tất cả')
	BEGIN
		SELECT ID, KhachHang, DiaChi, TongTien, NguoiDung FROM HOA_DON
	END

	IF (@idHoaDon = -1 AND @khachHang != N'Tất cả')
	BEGIN
		SELECT ID, KhachHang, DiaChi, TongTien, NguoiDung FROM HOA_DON where KhachHang = @khachHang
	END

	IF (@idHoaDon != -1 AND @khachHang = N'Tất cả')
	BEGIN
		SELECT ID, KhachHang, DiaChi, TongTien, NguoiDung FROM HOA_DON where ID = @idHoaDon
	END

	IF (@idHoaDon != -1 AND @khachHang != N'Tất cả')
	BEGIN
		SELECT ID, KhachHang, DiaChi, TongTien, NguoiDung FROM HOA_DON where ID = @idHoaDon and KhachHang = @khachHang
	END
GO
/****** Object:  StoredProcedure [dbo].[pro_LoadDanhSachKhachDangThuePhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LoadDanhSachKhachDangThuePhong] @ID INT
AS
	SELECT K.*
	FROM PHIEU_THUE AS PT, CHI_TIET_PHIEU_THUE AS CTPT, KHACH AS K
	WHERE PT.ID = CTPT.PhieuThue AND CTPT.Khach = K.ID AND PT.TinhTrang = 0 AND PT.Phong = @ID
GO
/****** Object:  StoredProcedure [dbo].[pro_LoadDanhSachLoaiKhach]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LoadDanhSachLoaiKhach]
AS
	SELECT *
	FROM LOAI_KHACH
GO
/****** Object:  StoredProcedure [dbo].[pro_LoadDanhSachLoaiPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LoadDanhSachLoaiPhong]
AS
	SELECT *
	FROM LOAI_PHONG
GO
/****** Object:  StoredProcedure [dbo].[pro_LoadDanhSachPhieuThueTheoTenPhongVaTinhTrang]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LoadDanhSachPhieuThueTheoTenPhongVaTinhTrang] @tenPhong NVARCHAR(30), @tinhTrang INT
AS
	IF (@tenPhong = N'Tất cả' AND @tinhTrang = -1)
	BEGIN
		SELECT PT.*, P.TenPhong FROM PHIEU_THUE PT, PHONG P WHERE PT.TinhTrang != -1 AND PT.Phong = P.ID
	END

	IF (@tenPhong = N'Tất cả' AND @tinhTrang != -1)
	BEGIN
		SELECT PT.*, P.TenPhong FROM PHIEU_THUE PT, PHONG P WHERE PT.TinhTrang != -1 AND PT.Phong = P.ID AND PT.TinhTrang = @TinhTrang
	END

	IF (@tenPhong != N'Tất cả' AND @tinhTrang != -1)
	BEGIN
		SELECT PT.*, P.TenPhong FROM PHIEU_THUE PT, PHONG P WHERE PT.TinhTrang != -1 AND PT.Phong = P.ID AND P.TenPhong = @tenPhong AND PT.TinhTrang = @tinhTrang
	END

	IF (@tenPhong != N'Tất cả' AND @tinhTrang = -1)
	BEGIN
		SELECT PT.*, P.TenPhong FROM PHIEU_THUE PT, PHONG P WHERE PT.TinhTrang != -1 AND PT.Phong = P.ID AND P.TenPhong = @tenPhong
	END
GO
/****** Object:  StoredProcedure [dbo].[pro_LoadDanhSachPhongTheoLoaiPhongVaTinhTrang]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LoadDanhSachPhongTheoLoaiPhongVaTinhTrang] @lp NVARCHAR(15), @tt INT
AS
	if (@lp = N'Tất cả' and  @tt = -2)
	begin
		exec pro_LoadDSPhong
	end

	if (@lp = N'Tất cả' and @tt != -2)
	begin
		Select P.ID, P.TenPhong, LP.TenLoai, P.GhiChu, P.TinhTrang
		from PHONG AS P, LOAI_PHONG AS LP
		where P.LoaiPhong = LP.ID and P.TinhTrang = @tt and P.TinhTrang != -1
		order by TenPhong ASC
	end

	if (@lp != N'Tất cả' and @tt!= -2)
	begin
		Select P.ID, P.TenPhong, LP.TenLoai, P.GhiChu, P.TinhTrang
		from PHONG AS P, LOAI_PHONG AS LP
		where P.LoaiPhong = LP.ID and @lp = LP.TenLoai and P.TinhTrang = @tt and P.TinhTrang != -1
		order by TenPhong ASC
	end

	if (@lp != N'Tất cả' and @tt = -2)
	begin
		Select P.ID, P.TenPhong, LP.TenLoai, P.GhiChu, P.TinhTrang
		from PHONG AS P, LOAI_PHONG AS LP
		where P.LoaiPhong = LP.ID and @lp = LP.TenLoai and P.TinhTrang != -1
		order by TenPhong ASC
	end

GO
/****** Object:  StoredProcedure [dbo].[pro_LoadDSPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pro_LoadDSPhong] 
as
	Select PHONG.ID, TenPhong, TenLoai, GhiChu, TinhTrang
	from PHONG, LOAI_PHONG
	where PHONG.LoaiPhong = LOAI_PHONG.ID and TinhTrang != -1
	order by TenPhong ASC
GO
/****** Object:  StoredProcedure [dbo].[pro_LoadLoaiPhongTheoTenPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LoadLoaiPhongTheoTenPhong] @tenPhong NVARCHAR(20)
AS
	DECLARE @idLoaiPhong INT;
	SET @idLoaiPhong = (SELECT TOP(1) LOAIPHONG FROM PHONG WHERE TenPhong = @tenPhong);
	SELECT * FROM LOAI_PHONG WHERE ID = @idLoaiPhong
GO
/****** Object:  StoredProcedure [dbo].[pro_LoadMaLoaiKhachTheoTenLoaiKhach]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_LoadMaLoaiKhachTheoTenLoaiKhach] @tenLoaiKhach NVARCHAR(30)
AS
	SELECT TOP(1) ID FROM LOAI_KHACH WHERE TenLoai = @tenLoaiKhach
GO
/****** Object:  StoredProcedure [dbo].[pro_SuaPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_SuaPhong] @TenPhong NVARCHAR(20), @loaiPhong NVARCHAR(20), @ghiChu NVARCHAR(500)
AS
	DECLARE @idLoaiPhong INT;
	SET @idLoaiPhong = (SELECT TOP(1) ID FROM LOAI_PHONG WHERE TenLoai = @loaiPhong);
	UPDATE PHONG SET LoaiPhong = @idLoaiPhong, GhiChu = @ghiChu WHERE TenPhong = @TenPhong;
GO
/****** Object:  StoredProcedure [dbo].[pro_TaoChiTietHoaDon]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_TaoChiTietHoaDon] @idHoaDon int, @idPhieuThue int, @soNgay int, @donGia money, @phuThu float, @tien money
AS
	INSERT INTO CHI_TIET_HOA_DON(HoaDon, PhieuThue, SoNgay, DonGia, PhuThu, Tien) VALUES(@idHoaDon, @idPhieuThue, @soNgay, @donGia, @phuThu, @tien);
	UPDATE PHIEU_THUE SET TinhTrang = 1 WHERE ID = @idPhieuThue;
GO
/****** Object:  StoredProcedure [dbo].[pro_TaoChiTietPhieuThue]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_TaoChiTietPhieuThue] @idPhieuThue INT, @hoTen NVARCHAR(30), @soCMND NVARCHAR(20), @diaChi NVARCHAR(50), @loaiKhach INT
AS
	EXEC pro_TaoKhach @hoTen, @soCMND, @diaChi, @loaiKhach;
	DECLARE @idKhachMax INT;
	SET @idKhachMax = (select max(ID) from KHACH);
	INSERT INTO CHI_TIET_PHIEU_THUE(PhieuThue, Khach) VALUES(@idPhieuThue, @idKhachMax)
GO
/****** Object:  StoredProcedure [dbo].[pro_TaoHoaDon]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_TaoHoaDon] @khachHang nvarchar(50), @diaChi nvarchar(50), @tongTien money, @idNguoiDung int
AS
	INSERT INTO HOA_DON(KhachHang, DiaChi, TongTien, NguoiDung) VALUES(@khachHang, @diaChi, @tongTien, @idNguoiDung);
GO
/****** Object:  StoredProcedure [dbo].[pro_TaoKhach]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_TaoKhach] @hoTen NVARCHAR(30), @soCMND NVARCHAR(20), @diaChi NVARCHAR(50), @loaiKhach INT
AS
	INSERT INTO KHACH (HoTen, CMND, DiaChi, LoaiKhach) VALUES (@hoTen, @soCMND, @diaChi, @loaiKhach)
GO
/****** Object:  StoredProcedure [dbo].[pro_TaoPhieuThue]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_TaoPhieuThue] @ngayThue DATETIME, @tinhTrang INT, @idPhong INT, @idNguoiDung INT
AS
	INSERT INTO PHIEU_THUE(NgayThue, TinhTrang, Phong, NguoiDung)
	VALUES (@ngayThue, @tinhTrang, @idPhong, @idNguoiDung)
GO
/****** Object:  StoredProcedure [dbo].[pro_ThemKhach]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_ThemKhach] @hoTen NVARCHAR(30), @cmnd NVARCHAR(15), @diaChi NVARCHAR(50), @tenLoaiKhach NVARCHAR(30)
AS
	DECLARE @idLoaiKhach INT;
	SET @idLoaiKhach = (SELECT TOP (1) ID FROM LOAI_KHACH WHERE TenLoai = @tenLoaiKhach);
	INSERT INTO KHACH(HoTen,CMND,DiaChi,LoaiKhach) VALUES (@hoTen, @cmnd, @diaChi, @idLoaiKhach);
GO
/****** Object:  StoredProcedure [dbo].[pro_ThemPhongMoi]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_ThemPhongMoi] @TenPhong NVARCHAR(10), @GhiChu NVARCHAR(300), @TenLoaiPhong NVARCHAR(30)
AS
	DECLARE @LoaiPhong int;
	set @LoaiPhong = (SELECT TOP(1) ID FROM LOAI_PHONG WHERE TenLoai = @TenLoaiPhong);
	insert into Phong(TenPhong, GhiChu, TinhTrang, LoaiPhong) values(@TenPhong, @GhiChu, 0, @LoaiPhong);
GO
/****** Object:  StoredProcedure [dbo].[pro_TraPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_TraPhong] @idPhong INT
AS
	UPDATE PHONG SET TinhTrang = 0 WHERE ID = @idPhong;
	UPDATE PHIEU_THUE SET NgayKetThuc = GETDATE(), TinhTrang = 2 where Phong = @idPhong AND TinhTrang = 0;
GO
/****** Object:  StoredProcedure [dbo].[pro_XoaPhong]    Script Date: 8/25/2020 8:18:29 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE PROCEDURE [dbo].[pro_XoaPhong] @tenPhong NVARCHAR(20)
AS
	UPDATE PHONG SET TinhTrang = -1 WHERE TenPhong = @tenPhong
	
GO
USE [master]
GO
ALTER DATABASE [QuanLyKhachSan] SET  READ_WRITE 
GO
