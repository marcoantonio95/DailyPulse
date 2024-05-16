//
//  AboutListView.swift
//  iosApp
//
//  Created by Marco Antonio on 10/04/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutListView: View {
    private struct RowItem: Hashable {
        let title: String
        let subTitle: String
    }
    
    private let items: [RowItem] = {
        let platform = Platform()
        platform.logSystemInfo()
        
        var result: [RowItem] = [
            RowItem(title: "Operating System", subTitle: "\(platform.osName) \(platform.osVersion)"),
            RowItem(title: "Device", subTitle: platform.deviceModel),
            RowItem(title: "Density", subTitle: "@\(platform.density)x"),
        ]
        
        return result
    }()
    
    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subTitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }
                .padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    AboutListView()
}
